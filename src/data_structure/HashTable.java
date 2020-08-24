package data_structure;

public class HashTable {
    public static void main(String[] args){
        HashTable t=new HashTable(3);
        EmpLinkedList t2=t.new EmpLinkedList();
        t.update(t2.new Emp(0,"小明",""));
        t.update(t2.new Emp(1,"小红",""));
        t.update(t2.new Emp(2,"小华",""));
        t.update(t2.new Emp(3,"小强",""));
        t.list();
    }

    public HashTable(int size){
        this.empLinkedListArr=new EmpLinkedList[size];
        this.size=size;
        for(int i=0;i<size;i++){
            empLinkedListArr[i]=new EmpLinkedList();
        }//不开坑 真的会报空指针异常
    }

    EmpLinkedList[] empLinkedListArr;
    int size;

    public void update(EmpLinkedList.Emp node){
        empLinkedListArr[hashFun(node.id)].update(node);
    }

    public EmpLinkedList.Emp find(int id){
        return empLinkedListArr[hashFun(id)].find(id);
    }

    public void list(){
        for(int i=0;i<size;i++){
            if(empLinkedListArr[i].empLinkedListHead!=null){
                empLinkedListArr[i].list();
            }
        }
    }

    public int hashFun(int id){//散列方法：简单的取模法，获得id对应的哪个链表。取模的理解是每组的size个元素分别放在LinkedListArr的不同表头下
        return id%size;
    }

    class EmpLinkedList {
        Emp empLinkedListHead = null;

        public void update(Emp node) {
            if(empLinkedListHead==null){
                empLinkedListHead=node;
                return;
            }
            Emp temp = empLinkedListHead;
            while (true) {
                if (temp.next == null) {
                    temp.next = node;
                    break;
                } else if (temp.next.id == node.id) {
                    node.next = temp.next.next;
                    temp.next = node;
                    break;
                } else if (temp.next.id > node.id) {
                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }

        public void list() {
            Emp temp = empLinkedListHead;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        public Emp find(int id) {
            Emp temp = empLinkedListHead;
            temp = temp.next;
            while (temp != null) {
                if (temp.id == id) {
                    return temp;
                } else {
                    temp = temp.next;
                }
            }
            System.out.println("Do not find!");
            return null;
        }

        public void del(int id) {
            Emp temp = empLinkedListHead;
            temp = temp.next;
            while (temp.next != null) {
                if (temp.next.id == id) {
                    temp.next = temp.next.next;
                    return;
                } else {
                    temp = temp.next;
                }
            }
            System.out.println("Do not find!");
        }

        class Emp {
            public Emp(int id, String name, String address) {
                this.id = id;
                this.name = name;
                this.address = address;
            }

            Emp next;
            String name;
            String address;
            int id;

            @Override
            public String toString() {
                return "Emp{id: " + id + " name: " + name + " add: " + address + " }";
            }
        }
    }
}
