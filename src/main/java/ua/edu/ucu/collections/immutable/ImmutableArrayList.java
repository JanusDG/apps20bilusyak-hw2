package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList {
    private final Object[] data;
    private final int lenght;

    public ImmutableArrayList(){
        this.data = new Object[]{};
        this.lenght = 0;
    }
    public ImmutableArrayList(Object[] c){
        this.lenght = c.length;
        this.data = new Object[this.lenght];
        for (int i = 0; i < this.lenght; i++){
            this.data[i] = c[i];
        }

    }
    ImmutableArrayList add(Object e){
        int len = this.lenght;
        Object[] c = new Object[len + 1];
        int i = 0;
        for (;i < len; i++){
            c[i] = this.data[i];
        }
        c[i] = e;
        return new ImmutableArrayList(c);

    } //додає елемент у кінець колекції
//
    ImmutableArrayList add(int index, Object e){
        int len = this.lenght;
        Object[] c = new Object[len + 1];
        int i = 0;
        for (;i < len + 1; i++){
            if (i < index){
                c[i] = this.data[i];
            }
            else if(i == index){
                c[i] = e;
            }
            else{
                c[i] = this.data[i - 1];
            }
        }
        return new ImmutableArrayList(c);
    } //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
//
    ImmutableArrayList addAll(Object[] c){
        ImmutableArrayList newList = new ImmutableArrayList(this.data);
        for (Object obj: c){
            newList = newList.add(obj);
        }
        return newList;

    }
    //додає масив елементів у кінець колекції
//
    ImmutableArrayList addAll(int index, Object[] c){
        ImmutableArrayList newList = new ImmutableArrayList(this.data);
        for (Object obj: c){
            newList = newList.add(index, obj);
        }
        return newList;
    }// додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
//
    Object get(int index){
        return this.data[index];
    } //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
//
    ImmutableArrayList remove(int index){
        int len = this.lenght;
        Object[] c = new Object[len - 1];
        int i = 0;
        for (;i < len - 1; i++){
            if (i < index){
                c[i] = this.data[i];
            }
            else{
                c[i] = this.data[i + 1];
            }
        }
        return new ImmutableArrayList(c);
    } //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
//
    ImmutableArrayList set(int index, Object e){
        Object[] data = this.data;
        data[index] = e;
        return new ImmutableArrayList(data);
    } //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
//
    int indexOf(Object e){
        for (int i = 0; i < this.lenght; i++){
            if (this.data[i] == e){
                return i;
            }
        }
        return -1;
    } //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
//
    int size(){
        return this.lenght;
    } //розмір колекції
//
    ImmutableArrayList clear(){
        return new ImmutableArrayList();
    } //очищує вміст колекції
//
    boolean isEmpty(){
        return this.lenght == 0;
    }//якщо у колеції нема елементів то повертає true
//
    Object[] toArray(){
        return this.data;
    } //перетворює колекцію до масиву обєктів
//
    @Override
    public String toString(){
        StringBuilder rez = new StringBuilder();
        for (Object obj: this.data){
            if (obj == null){
                continue;
            }
            rez.append(obj.toString()).append(", ");
        }
        return rez.toString();
    }//повертає рядок, де через кому відображаютсься елементи колекції
}
