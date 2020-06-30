package com.practice.algo.ds;

public class GraphPathCheck {
    private boolean isPathFound = false;

    public void checkAvailablePath(Graph g, Graph parent) {
        if (g.c == '.' && g.right == null && g.down == null) {
            isPathFound = true;
            parent.isPathAvailable = true;
        }
        if (g.isPathAvailable) {
            return;
        }
        if (g.right != null && g.right.c == '.' && !g.right.isVisited) {
            g.right.isVisited = true;
            checkAvailablePath(g.right, g);
        }

        if (g.left != null && g.left.c == '.' && !g.left.isVisited) {
            g.left.isVisited = true;
            checkAvailablePath(g.left, g);
        }

        if (g.up != null && g.up.c == '.' && !g.up.isVisited) {
            g.up.isVisited = true;
            checkAvailablePath(g.up, g);
        }

        if (g.down != null && g.down.c == '.' && !g.down.isVisited) {
            g.down.isVisited = true;
            checkAvailablePath(g.down, g);
        }

    }

    private static class Graph {
        char c;
        Graph left;
        Graph right;
        Graph up;
        Graph down;
        boolean isVisited;
        boolean isPathAvailable;

        Graph(char c) {
            this.c = c;
        }
    }

    public static void main(String[] s) {
        Graph g = new Graph('.');
        g.right = new Graph('X');
        g.down = new Graph('.');
        g.down.right = new Graph('.');
        GraphPathCheck gpc = new GraphPathCheck();
        gpc.checkAvailablePath(g, null);
        System.out.println(gpc.isPathFound);
    }
}
