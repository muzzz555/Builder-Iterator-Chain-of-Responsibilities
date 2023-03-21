import java.util.ArrayList;
import java.util.Collections;

interface Builder<T> {
    T BuildPart();
}

class Coffee {
    
}
class BuildCoffee implements Builder<Coffee> {

    public Coffee BuildPart() {
        return new Coffee();
    }
}

class GraphicComposite {

    public String name;
    public String color;
    public int width;
    public int height;
    public ArrayList<GraphicComposite> children = new ArrayList<>();
    public GraphicComposite(){

    }

    private void Print(StringBuilder stringBuilder, int depth) {
      stringBuilder.append(Collections.nCopies(depth, "*"))
      .append(name)
      .append(" ")
      .append(width)
      .append(" ")     
      .append(height)
      .append(System.lineSeparator());

      for (GraphicComposite child : children) {
        child.Print(stringBuilder, depth + 1);
      }
    }

    @Override
    public String toString() {

      // String returnString = color + " " + name + " " + width + " " + height + System.lineSeparator();
      
      // for (GraphicComposite child : children) {
      //   returnString = returnString + child.toString() + System.lineSeparator();
      // }
      // return returnString;

      StringBuilder sb = new StringBuilder();
      Print(sb, 0);
      return sb.toString();
    }
}

class Oval extends GraphicComposite {

  public Oval (String color, int width, int height){
    this.color = color;
    this.width = width;
    this.height = height;
    name = "Oval";
  }
}

class Rectangle extends GraphicComposite {

  public Rectangle (String color, int width, int height) {
    this.color = color;
    this.width = width;
    this.height = height;
    name = "Rectangle";
  }
}


public class Lab8Demo {
  public static void main(String[] args) {
    GraphicComposite drawing = new GraphicComposite();
    drawing.children.add(new Rectangle("Red", 100, 100));
    drawing.children.add(new Oval("Yellow", 200, 200));

    GraphicComposite group = new GraphicComposite();
    group.children.add(new Rectangle("Blue", 400, 400));
    group.children.add(new Oval("Blue", 300, 300));

    drawing.children.add(group);
    System.out.println(drawing);
  }
}
