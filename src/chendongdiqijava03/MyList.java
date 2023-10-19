/*
 * Clase MyList
 */
package chendongdiqijava03;

public class MyList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int counter;
    private Node<E> actualNode;

    public MyList() {
        this.firstNode = null;
        this.lastNode = null;
        this.counter = 0;
    }

    public void showMyList() {
        Node<E> temporary = this.firstNode;
        while (temporary != null) {
            System.out.println(temporary.getMain());
            temporary = temporary.getNextNode();
        }
    }

    /**
     * Añadir un nuevo nodo a la lista
     *
     * @param p Objeto a añadir
     */
    public void add(E p) {
        Node<E> newNode = new Node(p, this.counter + 1);
        if (this.firstNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.actualNode = newNode;
        } else {
            newNode.setPrevNode(this.lastNode);
            this.lastNode.setNextNode(newNode);
            this.lastNode = newNode;
        }
        this.counter++;
    }

    /**
     * Eliminar un nodo de la lista
     *
     * @param target Nodo a eliminar
     */
    public void delete(Node<E> target) {
        Node<E> aux = this.firstNode;

        while (aux != target) {
            aux = aux.getNextNode();
        }
        
        if (!aux.isFirstNode() && counter >= 1) {
            aux.getPrevNode().setNextNode(aux.getNextNode());
        } else {
            firstNode = aux.getNextNode();
        }
        
        if (!aux.isLastNode() && counter >= 1) {
            aux.getNextNode().setPrevNode(aux.getPrevNode());
        } else {
            lastNode = aux.getPrevNode();
        }
        
        counter--;
    }

    /**
     * Obtener el contenido de un nodo
     *
     * @param number Número del nodo
     * @return Contenido del nodo
     */
    public E get(int number) {
        Node<E> aux = this.firstNode;

        while (aux.getNumber() != number) {
            aux = aux.getNextNode();
        }

        return aux.getMain();
    }

    /**
     * Obtener el nodo actual de la lista
     *
     * @return Nodo actual
     */
    public Node<E> getActualNode() {
        return actualNode;
    }
    
    /**
     * Pasar al siguiente nodo
     */
    public void next() {
        this.actualNode = this.actualNode.getNextNode();
    }
        
    /**
     * Volver al anterior nodo
     */
    public void prev() {
        this.actualNode = this.actualNode.getPrevNode();
    }
    
    public int getCouter() {
        return this.counter;
    }
    
    public Node<E> getFirstNode() {
        return firstNode;
    }

// Inner class
    public class Node<E> {

        private Node<E> nextNode;
        private Node<E> prevNode;
        private E main;
        private int number;

        public Node(E p, int number) {
            this.nextNode = null;
            this.prevNode = null;
            this.main = p;
            this.number = number;
        }

        public Node<E> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }

        public E getMain() {
            return main;
        }

        public void setMain(E p) {
            this.main = p;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        /**
         * Indica si el nodo actual es el primer nodo
         *
         * @return true si es el primer nodo, false si no
         */
        public boolean isFirstNode() {
            return firstNode == this;
        }

        /**
         * Indica si el nodo actual es el último nodo
         *
         * @return true si es el último nodo, false si no
         */
        public boolean isLastNode() {
            return lastNode == this;
        }
    }
}
