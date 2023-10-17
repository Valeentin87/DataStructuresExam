package org.example;

class BinaryTree {
    Node root; // root-овая нода, корень бинарного дерева

    class Node {   // класс узла
        int value;  // значение ноды
        Node left; // левый дочерний элемент
        Node right; // правый дочерний элемент

    }

    public Boolean find(int value) { // метод поиска элемента в дереве
        Node node = root;
        while (node != null) {
            if (node.value == value) { // если значение текущей ноды равно искомому значению
                return true;
            }
            if (node.value < value) { // если значение текущей ноды меньше, чем искомое значение значит смещаемся вправо
                node = node.right; // переходим на правую дочернюю ноду
            } else {
                node = node.left; // иначе переходим на левую дочернюю ноду
            }
        }
        return false;  // если не нашли интересующее нас искомое значение
    }

    public void insert(int value) { // вставка значения в бинарное дерево
        if (root == null) { // если корень пустой
            root = new Node(); // создаем новый root
            root.value = value; // присваиваем новому корню вставляемое значение
        } else {  // если корень уже имеется (не пустой) реализуем вставку вниз по корню
            insert(root, value); // использование приватного метода внутри обычного метода, поскольку мы кроме root другой нодф не знаем
        }
    }

    private Boolean insert(Node node, int value) { // приватный метод, вставляющий значение в нужное место
        if (node.value == value) { // если уже имеется нода с таким значением, которое хотим вставить
            return false;
        }
        if (node.value < value) { // если значение ноды меньше вставляемого значения проверяем наличие правой дочерней ноды
            if (node.right == null) { // правой дочерней ноды нет, то вставляем значение как правую ноду
                node.right = new Node(); // создаем правую дочернюю ноду
                node.right.value = value; // присваиваем значение правой дочерней ноде равное вставляемому
                return true;
            } else {
                return insert(node.right, value); // если есть правая дочерняя нода, то рекурсивно пробуем выполнять метод вставки
            }
        } else { // все тоже самое делаем в  случае, если значение ноды больше, чем искомое значение - падаем в левую ветку
            if (node.value > value) { // если значение ноды больше вставляемого значения проверяем наличие левой дочерней ноды
                if (node.left == null) { // если левой дочерней ноды нет, то вставляем значение как левую ноду
                    node.left = new Node(); // создаем левую дочернюю ноду
                    node.left.value = value; // присваиваем значение левой дочерней ноде равное вставляемому
                    return true;
                } else {
                    return insert(node.left, value); // если есть левая дочерняя нода, то рекурсивно пробуем выполнять метод вставки
                }
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BinaryTree tree = new BinaryTree();
        for(int i=1; i<=10; i++){
            tree.insert(i);
        }
    }
}