#Generate HTML Tables
Generate a beautiful HTML tables to show any data.
* **Generated CSSs is inline**, to be compatible with the major email clients.
* The cells of the HTML Table **can also contains HTML** code.
* The first row of the matrix represents the header of the HTML Table.


##How to use
Create a matrix representing your data. As said before, the matrix also can have HTML as content.
Here's an example:

```java
class Main{
    public static void main(String[] args) {
        TableGenerator gen = new TableGeneratorImpl();
        String data[][] = new String[2][4];

        String html = gen.generateHtmlTable(data);
        System.out.println(html);
    }
}
```
