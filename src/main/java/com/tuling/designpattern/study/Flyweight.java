package com.tuling.designpattern.study;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName Flyweight.java
 * @Description TODO 享元模式
 * 假设需要渲染一片森林(1000000)
 * @createTime 2023年02月16日 16:33:00
 */
public class Flyweight {
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {

//        Tree trees = new Tree(3, 4, TreeFactory.getTreeType("xxx", Color.BLACK, "xxx"));
//        Tree trees2 = new Tree(3, 4, TreeFactory.getTreeType("xxx", Color.BLACK, "xxx"));
//        Tree trees3 = new Tree(3, 4, TreeFactory.getTreeType("xxx", Color.BLACK, "xxx"));
//        System.out.println(trees);
//        System.out.println(trees2);
//        System.out.println(trees3);

        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");

    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}

@Data
@AllArgsConstructor
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}

// 树的类型信息
@Data
@AllArgsConstructor
class TreeType {
    private String name; // 名称
    private Color color; // 颜色
    private String otherTreeData; // 其他信息

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}

// 树工厂信息，
class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}

class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);

    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
