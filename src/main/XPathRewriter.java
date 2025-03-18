package main;

import main.antlr.XPathBaseVisitor;
import main.antlr.XPathLexer;
import main.antlr.XPathParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class XPathRewriter extends XPathBaseVisitor<String> {
    private static final String delimiter = "_";
    private static final String tab = "\t";

    @Override
    public String visitXq(XPathParser.XqContext ctx) {
        if (ctx.forClause() != null) {
            return visitFor(ctx);
        }
        return super.visitXq(ctx);
    }

    public String visitFor(XPathParser.XqContext ctx) {
        Map<String, String> varToXq = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();

        Map<String, Integer> varToIdx = new HashMap<>();
        List<List<String>> idxToVars = new ArrayList<>();


        Map<Integer, List<String>> selfCond = new HashMap<>();
        Map<String, List<String[]>> interCond = new HashMap<>();
        List<String> joinOrder = new ArrayList<>();

        List<String> forBlocks = new ArrayList<>();

        // parse for clause
        int groupCounter = 0;

        for (int i = 0; i < ctx.forClause().var().size(); i++) {
            String var = ctx.forClause().var(i).getText();
            String xq = ctx.forClause().xq(i).getText();

            varToXq.put(var, xq);

            if (!xq.isEmpty() && xq.charAt(0) == '$') { // has parent
                String parentVar = xq.split("/")[0];
                int parentIdx = varToIdx.getOrDefault(parentVar, groupCounter);
                parentMap.put(var, parentVar);
                varToIdx.put(var, parentIdx);
                idxToVars.get(parentIdx).add(var);
            } else {  // root node
                varToIdx.put(var, groupCounter);
                idxToVars.add(new ArrayList<>());
                idxToVars.get(groupCounter).add(var);
                groupCounter++;
            }
        }

        // create inverse mapping varToIdx to idxToVars
//        for (int i = 0; i < groupCounter; i++) {
//            idxToVars.add(new ArrayList<>());
//        }
//        for (Map.Entry<String, Integer> entry : varToIdx.entrySet()) {
//            int groupId = entry.getValue();
//            idxToVars.get(groupId).add(entry.getKey());
//        }

        // debug
//        for (Map.Entry<String, Integer> entry : varToIdx.entrySet()) {
//            System.out.println(entry.getKey() + " Group " + entry.getValue());
//        }
//        for (Map.Entry<String, String> entry : parentMap.entrySet()) {
//            System.out.println(entry.getKey() + " Parent: " + entry.getValue());
//        }
//        for (int i = 0; i < idxToVars.size(); i++) {
//            System.out.println("Group " + i + " " + idxToVars.get(i));
//            for (String var: idxToVars.get(i)) {
//                System.out.println("Var " + var + " in " + varToXq.get(var));
//            }
//        }

        // parse where
        if (ctx.whereClause() != null) {
            String whereClause = ctx.whereClause().getText().replaceFirst("where", "");
            String[] conditions = whereClause.split("and");

            for (String condition : conditions) {
                String[] vars;

                if (condition.contains("eq")) {
                    vars = condition.split("eq");
                }
                else if (condition.contains("=")) {
                    vars = condition.split("=");
                } else {
                    System.err.println("Invalid condition format 111 in where clause: " + condition);
                    continue;
                }

                String left = vars[0], right = vars[1];

                if (left.charAt(0) == '$' && right.charAt(0) == '$') {  // case 1: var eq var
                    int leftIdx = varToIdx.get(left);
                    int rightIdx = varToIdx.get(right);

                    if (leftIdx == rightIdx) {  // same group, self condition
                        selfCond.putIfAbsent(leftIdx, new ArrayList<>());
                        selfCond.get(leftIdx).add(left + " eq " + right);
                    }
                    else {                      // diff groups, inter condition
                        // small groupid comes first
                        if (rightIdx < leftIdx){
                            int tempIdx = leftIdx;
                            leftIdx = rightIdx;
                            rightIdx = tempIdx;
                            String tempVar = left;
                            left = right;
                            right = tempVar;
                        }

                        String key = String.valueOf(leftIdx) + delimiter + String.valueOf(rightIdx);
                        interCond.putIfAbsent(key, new ArrayList<>());
                        interCond.get(key).add(new String[]{left, right});

                        if (!joinOrder.contains(key)) {
                            joinOrder.add(key);
                        }
                    }
                }
                else if (right.charAt(0) == '\"') {    // case 2: var eq const
                    int leftIdx = varToIdx.get(left);
                    selfCond.putIfAbsent(leftIdx, new ArrayList<>());
                    selfCond.get(leftIdx).add(left + " eq " + right);
                }
                else {
                    System.err.println("Invalid condition format 222 in where clause: " + condition);
                    continue;
                }
            }
        }

        // debug
//        System.out.println("\nSelf Conditions");
//        for (Map.Entry<Integer, List<String>> entry : selfCond.entrySet()) {
//            System.out.println("Group " + entry.getKey() + ": " + entry.getValue());
//        }
//        System.out.println("\nInter-group Conditions");
//        for (Map.Entry<String, List<String[]>> entry : interCond.entrySet()) {
//            System.out.print("Groups " + entry.getKey() + ": ");
//            for (String[] pair : entry.getValue()) {
//                System.out.print(Arrays.toString(pair) + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("\nJoin Order");
//        System.out.println(joinOrder);

        // generate for blocks
        for (int i = 0; i < idxToVars.size(); i++) {
            StringBuilder forBlock = new StringBuilder();
            forBlock.append("for ");

            // add for clause
            List<String> vars = idxToVars.get(i);
            for (int j = 0; j < vars.size(); j++) {
                String var = vars.get(j);
                String xq = varToXq.get(var);

                forBlock.append(var).append(" in ").append(xq);
                if (j < vars.size() - 1) {
                    forBlock.append(",\n").append(tab);
                }
            }

            // add where clause
            if (selfCond.containsKey(i)) {
                forBlock.append("\nwhere ");

                List<String> conditions = selfCond.get(i);
                for (int j = 0; j < conditions.size(); j++) {
                    forBlock.append(conditions.get(i));
                    if (j < conditions.size() - 1) {
                        forBlock.append(" and ");
                    }
                }
            }

            // add return clause
            forBlock.append("\nreturn <tuple>{ ");
            for (int j = 0; j < vars.size(); j++) {
                String var = vars.get(j);
                forBlock.append("<").append(var.substring(1)).append(">{").append(var).append("}</").append(var.substring(1)).append(">");

                if (j < vars.size() - 1) {
                    forBlock.append(", ");
                }
            }
            forBlock.append(" }</tuple>");

            forBlocks.add(forBlock.toString());
        }

        //debug
//        for (int i = 0; i < forBlocks.size(); i++) {
//            if (!forBlocks.get(i).isEmpty()) {
//                System.out.println("Group " + i + ":\n" + forBlocks.get(i) + "\n");
//            }
//        }

        // process join
        List<String> joinBlocks = new ArrayList<>();
        Set<Integer> joinSet = new HashSet<>();

        int nestedJoinIdx = -1;

        for (int i = 0; i < joinOrder.size(); i++) {
            String joinKey = joinOrder.get(i);
            String[] pair = joinKey.split(delimiter);
            int leftIdx = Integer.parseInt(pair[0]);
            int rightIdx = Integer.parseInt(pair[1]);

            String leftBlock = forBlocks.get(leftIdx);
            String rightBlock = forBlocks.get(rightIdx);

            // parallel join
            if (!joinSet.contains(leftIdx) && !joinSet.contains(rightIdx)) {
                StringBuilder joinBlock = new StringBuilder();
                joinBlock.append("join (\n").append(leftBlock).append(",\n").append(rightBlock).append(",\n");

                List<String[]> conditions = interCond.get(joinKey);
                joinBlock.append("[");

                for (int j = 0; j < conditions.size(); j++) {
                    joinBlock.append(conditions.get(j)[0].substring(1));
                    if (j < conditions.size() - 1) {
                        joinBlock.append(", ");
                    }
                }
                joinBlock.append("],[");

                for (int j = 0; j < conditions.size(); j++) {
                    joinBlock.append(conditions.get(j)[1].substring(1));
                    if (j < conditions.size() - 1) {
                        joinBlock.append(", ");
                    }
                }
                joinBlock.append("]\n)");

                joinSet.add(leftIdx);
                joinSet.add(rightIdx);
                joinBlocks.add(joinBlock.toString());
            }
            else {
                nestedJoinIdx = i;
                //debug
                System.out.println("require nested join: " + joinKey);
            }
        }

        if (nestedJoinIdx != -1) {
            String joinKey = joinOrder.get(nestedJoinIdx);
            String leftBlock, rightBlock;

            if (joinBlocks.size() == 1) {       // case 1: only 1 join block
                leftBlock = joinBlocks.remove(0);
                rightBlock = forBlocks.get(Integer.parseInt(joinOrder.get(nestedJoinIdx).split(delimiter)[1]));
            }
            else if (joinBlocks.size() == 2) {  // case 2: 2 join blocks, parallel join
                leftBlock = joinBlocks.remove(0);
                rightBlock = joinBlocks.remove(0);
            }
            else {
                //debug
                System.out.println("Something went wrong!!! joinBlocks size incorrect: " + joinBlocks.size());
                // early exit???
                return "";
            }

            StringBuilder joinBlock = new StringBuilder();
            joinBlock.append("join (\n").append(leftBlock).append(",\n").append(rightBlock).append(",\n");

            List<String[]> conditions = interCond.get(joinKey);
            joinBlock.append("[");

            for (int j = 0; j < conditions.size(); j++) {
                joinBlock.append(conditions.get(j)[0].substring(1));
                if (j < conditions.size() - 1) {
                    joinBlock.append(", ");
                }
            }
            joinBlock.append("],[");

            for (int j = 0; j < conditions.size(); j++) {
                joinBlock.append(conditions.get(j)[1].substring(1));
                if (j < conditions.size() - 1) {
                    joinBlock.append(", ");
                }
            }
            joinBlock.append("]\n)");

            joinBlocks.add(joinBlock.toString());
        }

        if (joinBlocks.size() != 1) {
            System.out.println("Something went wrong!!! joinBlocks should be size 1, size: " + joinBlocks.size());
        }

        String resultQuery = "for $tuple in " + joinBlocks.get(0) + "\n";
        resultQuery += ctx.returnClause().getText().replace("$", "$tuple/");

        // debug
        System.out.println("\nFinal rewrite query:\n" + resultQuery);

        return resultQuery;

    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java XPathRewriter <input file> <output file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            String input = new String(Files.readAllBytes(Paths.get(inputFile)));
            XPathLexer lexer = new XPathLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathParser parser = new XPathParser(tokens);
            ParseTree tree = parser.xq();

            XPathRewriter rewriter = new XPathRewriter();
            String result = rewriter.visit(tree);

            Files.write(Paths.get(outputFile), result.getBytes());
            System.out.println("Rewrite result saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
