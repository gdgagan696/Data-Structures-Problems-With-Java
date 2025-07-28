package dsquestions;

public class MyHashMap_2 {
    class MapInfo{
        int key;
        int val;
        MapInfo next;

        public MapInfo(int key, int val, MapInfo next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    MapInfo hashMap[];
    public MyHashMap_2() {
        hashMap=new MapInfo[15];
    }

    public void put(int key, int value) {
        int index=key%15;
        MapInfo mapInfo=hashMap[index];
        MapInfo newVal=new MapInfo(key,value, null);
        if(mapInfo==null){
            hashMap[index]=newVal;
        }
        else {
            MapInfo head=mapInfo;
            MapInfo prev=null;
            while (head!=null){
                if(head.key==key){
                    head.val=value;
                    return;
                }
                else {
                    prev=head;
                    head=head.next;
                }
            }
            prev.next=mapInfo;
        }

    }

    public int get(int key) {
        int index=key%15;
        MapInfo mapInfo=hashMap[index];
        return mapInfo==null?-1:mapInfo.val;

    }

    public void remove(int key) {
        int index=key%15;
        MapInfo mapInfo=hashMap[index];
        if(mapInfo==null){
            return;
        }
        else {
            MapInfo head=mapInfo;
            MapInfo prev=null;
            while (head!=null){
                if(head.key==key){
                    if(prev==null){
                        hashMap[index]=head.next;
                    }
                    else {
                        prev.next = head.next;
                    }
                    return;
                }
                else {
                    prev=head;
                    head=head.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap_2 myHashMap = new MyHashMap_2();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.put(3, 3);
        myHashMap.put(4, 4);
        myHashMap.put(20, 6);

        System.err.println(myHashMap.get(4));
        System.err.println(myHashMap.get(20));
        System.err.println(myHashMap.get(1));

        myHashMap.remove(4);

        System.err.println(myHashMap.get(4));
        System.err.println(myHashMap.get(20));
    }
}
