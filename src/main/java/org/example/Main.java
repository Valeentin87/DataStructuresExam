package org.example;

class BinaryTree{
    Node root; // root-овая нода, корень бинарного дерева

    class Node{   // класс узла
        int value;  // значение ноды
        Node left; // левый дочерний элемент
        Node right; // правый дочерний элемент

    }

    public Boolean find(int value){ // метод поиска элемента в дереве
        Node node = root;
        while(node != null) {
            if(node.value == value){ // если значение текущей ноды равно искомому значению
                return true;
            }
            if(node.value < value){ // если значение текущей ноды меньше, чем искомое значение значит смещаемся вправо
                node = node.right; // переходим на правую дочернюю ноду
            }
            else{
                node = node.left; // иначе переходим на левую дочернюю ноду
            }
        }
        return false;  // если не нашли интересующее нас искомое значение
    }

}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}