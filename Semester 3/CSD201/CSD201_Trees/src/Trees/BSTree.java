package Trees;

public class BSTree {

    private Node root;

    public BSTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    void insert(int x) {
        //Tree rong
        if (this.root == null) {
            this.root = new Node(x);
            return;
        }
        //Tre khong rong
        Node p, q;
        p = this.root;
        q = null;
        while (p != null) {
            //x da ton tai tren Tree
            if (x == p.getData()) {
                System.out.println(x + " is already existing");
                return;
            }
            //x khong ton tai tren Tree
            q = p;
            if (x < p.getData()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < q.getData()) {
            q.left = new Node(x);
        } else {
            q.right = new Node(x);
        }
    }

    //---------------------------------
    void visit(Node p) {
        System.out.print(p.getData() + "  ");
    }

    //---------------------------------
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    //---------------------------------
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    //----------------------------
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    //----------------------------
    void delete(int x) {
        if (this.root == null) {
            return;
        }
        Node p, q;
        p = this.root;
        q = null;
        while (p != null && x != p.getData()) {
            q = p;
            if (x < p.getData()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //neu x khong co trong Tree
        if (p == null) {
            System.out.println(x + " is not existing in Tree");
            return;
        }
        //tim thay x trong Tree
        //Truong hop 1: p la not la
        if (p.left == null && p.right == null) {
            if (x < q.getData()) {
                q.left = null;
            } else {
                q.right = null;
            }
            return;
        }
        //Truong hop 2: p co 1 not con
        //p co 1 not con ben phai
        if (p.left == null) {
            if (x < q.getData()) {
                q.left = p.right;
            } else {
                q.right = p.right;
            }
            return;
        }
        //p co 1 not con ben trai
        if (p.right == null) {
            if (x < q.getData()) {
                q.left = p.left;
            } else {
                q.right = p.left;
            }
            return;
        }
        //Truong hop 3: p  co 2 not con
        //Thay the p bang not con lon nhat ben nhanh trai
        //Di tim not con lon nhat ben nhanh trai
        Node p1, q1;
        p1 = p.left;
        q1 = null;
        while (p1.right != null) {
            q1 = p1;
            p1 = p1.right;
        }
        //not con lon nhat ben trai la not la
        if (p1.left == null) {
            p.setData(p1.getData());
            q1.right = null;
            //Not con lon nhat ben trai co 1 not con trai
        } else {
            p.setData(p1.getData());
            q1.right = p1.left;
        }
    }
}
