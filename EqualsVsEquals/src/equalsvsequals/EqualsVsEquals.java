/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equalsvsequals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author giorgos
 */
public class EqualsVsEquals {

    enum ObjectType {
        STRING("String"), STRINGBUILDER("StringBuilder"), STRIGBUFFER("StringBuffer"),
        PERSON("Person"), PERSON_EQUALS("PersonEqualsOverriden"),
        PERSON_HASHCODE("PersonHashCodeOverriden"), PERSON_EQUALS_HASHCODE("PersonEqualsHashCodeOverriden");

        private String objectType;

        ObjectType(String objectType) {
            this.objectType = objectType;
        }

        public String getObjectType() {
            return objectType;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        general();
        stringsEquality();
        stringBuilderEquality();
        stringBufferEquality();
        objectsEquality();
        objectsEqualityEqualsOverriden();
        objectsEqualityHashCodeOverriden();
        objectsEqualityEqualsHashCodeOverriden();
    }

    static void general() {
        printTitle("GENERAL");
        printSubtitle("1. Immutability of Strings.");
        System.out.println("    JVM optimizes the amount of memory allocated for Strings by\n"
                + "storing only one copy of each literal String in the \"Pool of Strings\".\n"
                + "When we create a String varialbe and directly assign a value to it,\n"
                + "the JVM searches the Pool for a String of equal value.\n"
                + "    If found, it returns a reference to it's memory address, without allocating\n"
                + "additional memory. If not found, it stores a copy in the Pool and returns\n"
                + "it's reference.\n"
                + "    When we create a String using the new() operator, the JVM always\n"
                + "creates a new object in the Heap.\n"
                + "    Before Java 7, the Pool was placed in the PermGen space, which has\n"
                + "a fixed size and is not eligible for GC. This may would conclude into a\n"
                + "OutOfMemory error if we interned too many Strings. From Java 7 and on,\n"
                + "the Pool is stored in the Heap which is garbage collected, reducing the\n"
                + "risk of OutOfMemory error.\n"
                + "source: https://www.baeldung.com/java-string-pool \n");

        printSubtitle("2. Equality operators");
        System.out.println("== :\t\toperator");
        System.out.println("equals() :\tmethod");
        System.out.println("== :\t\tmemory address comparison");
        System.out.println("equals() :\tcontent comparison");

        System.out.println("\ne.g.: s1 == s2 comparison means\n"
                + "\"Does s1 points to the same memory address as s2?\"");
        System.out.println("\ne.g.: s1.equals(s2) comparison means\n"
                + "\"Does the memory address that is referenced by s1 contains\n"
                + "the same value as the value of the memory address that is referenced by s2?\"\n");

        printSubtitle("3. About hashCode:");
        System.out.println("Objects that are equal according to their equals() method must return the same hashCode.");
        System.out.println("The opposite is not required but preferred.");
        System.out.println("more info: https://www.baeldung.com/java-hashcode");

        System.out.println("\n");
    }

    static void stringsEquality() {
        String a = "Jason";
        String b = new String("Jason");
        String c = a;
        String d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("STRINGS EQUALITY");
        printAssignments(ObjectType.STRING);
        printHashCodes(map);
        equals(map);
        otherComparisonsForStrings(map, StringType.STRING);
    }

    static void stringBuilderEquality() {
        StringBuilder a = new StringBuilder("Jason");
        StringBuilder b = new StringBuilder("Jason");
        StringBuilder c = a;
        StringBuilder d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("STRING BUILDER EQUALITY");
        printAssignments(ObjectType.STRINGBUILDER);
        printHashCodes(map);
        equals(map);
        otherComparisonsForStrings(map, StringType.STRINGBUILDER);
    }

    static void stringBufferEquality() {
        StringBuffer a = new StringBuffer("Jason");
        StringBuffer b = new StringBuffer("Jason");
        StringBuffer c = a;
        StringBuffer d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("STRING BUFFER EQUALITY");
        printAssignments(ObjectType.STRIGBUFFER);
        printHashCodes(map);
        equals(map);
        otherComparisonsForStrings(map, StringType.STRINGBUFFER);
    }

    static void objectsEquality() {

        Person a = new Person("Jason");
        Person b = new Person("Jason");
        Person c = a;
        Person d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("OBJECTS ARE NOT IMMUTABLE");
        printAssignments(ObjectType.PERSON);
        printHashCodes(map);
        equals(map);
        otherComparisonsForObjects(map, ObjectOverrideType.NOOVERRIDE);
    }

    static void objectsEqualityEqualsOverriden() {

        PersonEqualsOverriden a = new PersonEqualsOverriden("Jason");
        PersonEqualsOverriden b = new PersonEqualsOverriden("Jason");
        PersonEqualsOverriden c = a;
        PersonEqualsOverriden d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("OBJECTS EQUALS OVERRIDEN");
        printAssignments(ObjectType.PERSON_EQUALS);
        printHashCodes(map);
        equals(map);
        otherComparisonsForObjects(map, ObjectOverrideType.EQUALS);
    }

    static void objectsEqualityHashCodeOverriden() {

        PersonHashCodeOverriden a = new PersonHashCodeOverriden("Jason");
        PersonHashCodeOverriden b = new PersonHashCodeOverriden("Jason");
        PersonHashCodeOverriden c = a;
        PersonHashCodeOverriden d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("OBJECTS HASHCODE OVERRIDEN");
        printAssignments(ObjectType.PERSON_HASHCODE);
        printHashCodes(map);
        equals(map);
        otherComparisonsForObjects(map, ObjectOverrideType.HASHCODE);
    }

    static void objectsEqualityEqualsHashCodeOverriden() {

        PersonEqualsHashCodeOverriden a = new PersonEqualsHashCodeOverriden("Jason");
        PersonEqualsHashCodeOverriden b = new PersonEqualsHashCodeOverriden("Jason");
        PersonEqualsHashCodeOverriden c = a;
        PersonEqualsHashCodeOverriden d = b;

        Map<String, Object> map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        
        printTitle("OBJECTS EQUALS & HASHCODE OVERRIDEN");
        printAssignments(ObjectType.PERSON_EQUALS_HASHCODE);
        printHashCodes(map);
        equals(map);
        otherComparisonsForObjects(map, ObjectOverrideType.EQUALSHASHCODE);
    }

    static String dash = String.join("", Collections.nCopies(65, "-"));
    

    static int left(String title) {
        return (dash.length() - title.length()) / 2;
    }

    static int right(String title) {
        return dash.length() - title.length() - left(title);
    }
    
    static void printTitle(String title) {
        System.out.println(dash);
        System.out.printf("%1$-" + (dash.length()-1) + "s%1$s\n", "|");
        System.out.printf("%1$-" + left(title) + "s%2$s%1$" + right(title) + "s\n", "|", title);
        System.out.printf("%1$-" + (dash.length()-1) + "s%1$s\n", "|");
        System.out.println(dash);
        System.out.println("");
    }
    
    static void printSubtitle(String subtitle) {
        System.out.println();
        System.out.printf("%" + left(subtitle) + "s%s\n", "", subtitle);
        System.out.println(dash);
    }
    
    static void printAssignments(ObjectType type) {
        printSubtitle("INITIALIZATION");
        if (type.equals(ObjectType.STRING)) {
            System.out.println(type.getObjectType() + " a = \"Jason\"");
        } else {
            System.out.println(type.getObjectType() + " a = new " + type.getObjectType() + "(\"Jason\")");
        }

        System.out.println(type.getObjectType() + " b = new " + type.getObjectType() + "(\"Jason\")");
        System.out.println(type.getObjectType() + " c = a");
        System.out.println(type.getObjectType() + " d = b");
    }

    static void printHashCodes(Map<String, Object> x) {
        printSubtitle("HASHCODES");
        x.forEach((s, o) -> {
            if (o instanceof Person) {
                System.out.println(s + ".getName().hashCode(): " + ((Person) o).getName().hashCode());
            }
        });

        x.forEach((s, o) -> System.out.println(s + ".hashCode(): " + o.hashCode()));
    }

    static void equals(Map<String, Object> x) {
        printSubtitle("EQUALS vs. ==");
        System.out.println("a.equals(b):\t" + x.get("a").equals(x.get("b")));
        System.out.println("a.equals(c):\t" + x.get("a").equals(x.get("c")));
        System.out.println("a.equals(d):\t" + x.get("a").equals(x.get("d")));
        System.out.println("a == b:\t\t" + (x.get("a") == x.get("b")));
        System.out.println("a == c:\t\t" + (x.get("a") == x.get("c")));
        System.out.println("a == d:\t\t" + (x.get("a") == x.get("d")));

        System.out.println();

        System.out.println("b.equals(c):\t" + x.get("b").equals(x.get("c")));
        System.out.println("b.equals(d):\t" + x.get("b").equals(x.get("d")));
        System.out.println("b == c:\t\t" + (x.get("b") == x.get("c")));
        System.out.println("b == d:\t\t" + (x.get("b") == x.get("d")));

        System.out.println();

        System.out.println("c.equals(d):\t" + x.get("c").equals(x.get("d")));
        System.out.println("c == d:\t\t" + (x.get("c") == x.get("d")));

    }

    static void otherComparisonsForStrings(Map<String, Object> x, StringType type) {
        printSubtitle("OTHER COMPARISONS");
        System.out.printf("%-70s%s\n", "\"Jason\".equals(a):", "Jason".equals(x.get("a")));
        System.out.printf("%-70s%s\n", "\"Jason\" == a:", ("Jason" == x.get("a")));
        if (type == StringType.STRING) {
            System.out.printf("%-70s%s\n", "new String(\"Jason\").equals(a):", new String("Jason").equals(x.get("a")));
            System.out.printf("%-70s%s\n", "new String(\"Jason\") == a:", (new String("Jason") == x.get("a")));
        } else if (type == StringType.STRINGBUILDER) {
            System.out.printf("%-70s%s\n", "new StringBuilder(\"Jason\").equals(a):", new StringBuilder("Jason").equals(x.get("a")));
            System.out.printf("%-70s%s\n", "new StringBuilder(\"Jason\") == a:", (new StringBuilder("Jason") == x.get("a")));
        } else if (type == StringType.STRINGBUFFER) {
            System.out.printf("%-70s%s\n", "new StringBuffer(\"Jason\").equals(a):", new StringBuffer("Jason").equals(x.get("a")));
            System.out.printf("%-70s%s\n", "new StringBuffer(\"Jason\") == a:", (new StringBuffer("Jason") == x.get("a")));
        }

        System.out.println();
        System.out.printf("%-70s%s\n", "\"Jason\".equals(b):", "Jason".equals(x.get("b")));
        System.out.printf("%-70s%s\n", "\"Jason\" == b:", ("Jason" == x.get("b")));
        if (type == StringType.STRING) {
            System.out.printf("%-70s%s\n", "new String(\"Jason\").equals(b):", new String("Jason").equals(x.get("b")));
            System.out.printf("%-70s%s\n", "new String(\"Jason\") == b:", (new String("Jason") == x.get("b")));
        } else if (type == StringType.STRINGBUILDER) {
            System.out.printf("%-70s%s\n", "new StringBuilder(\"Jason\").equals(b):", new StringBuilder("Jason").equals(x.get("b")));
            System.out.printf("%-70s%s\n", "new StringBuilder(\"Jason\") == b:", (new StringBuilder("Jason") == x.get("b")));
        } else if (type == StringType.STRINGBUFFER) {
            System.out.printf("%-70s%s\n", "new StringBuffer(\"Jason\").equals(b):", new StringBuffer("Jason").equals(x.get("b")));
            System.out.printf("%-70s%s\n", "new StringBuffer(\"Jason\") == b:", (new StringBuffer("Jason") == x.get("b")));
        }

        System.out.println();
        System.out.printf("%-70s%s\n", "\"Jason\".equals(\"Jason\"):", "Jason".equals("Jason"));
        System.out.printf("%-70s%s\n", "\"Jason\" == \"Jason\":", ("Jason" == "Jason"));

        if (type == StringType.STRING) {
            System.out.printf("%-70s%s\n", "new String(\"Jason\").equals(new String(\"Jason\")):", new String("Jason").equals(new String("Jason")));
            System.out.printf("%-70s%s\n", "new String(\"Jason\") == new String(\"Jason\"):", (new String("Jason") == new String("Jason")));
        } else if (type == StringType.STRINGBUILDER) {
            System.out.printf("%-70s%s\n", "new StringBuilder(\"Jason\").equals(new StringBuilder(\"Jason\")):", new StringBuilder("Jason").equals(new StringBuilder("Jason")));
            System.out.printf("%-70s%s\n", "new StringBuilder(\"Jason\") == new StringBuilder(\"Jason\"):", (new StringBuilder("Jason") == new StringBuilder("Jason")));

        } else if (type == StringType.STRINGBUFFER) {
            System.out.printf("%-70s%s\n", "new StringBuffer(\"Jason\").equals(new StringBuffer(\"Jason\")):", new StringBuffer("Jason").equals(new StringBuffer("Jason")));
            System.out.printf("%-70s%s\n", "new StringBuffer(\"Jason\") == new StringBuffer(\"Jason\"):", (new StringBuffer("Jason") == new StringBuffer("Jason")));
        }

        System.out.println("\n\n");

    }

    static void otherComparisonsForObjects(Map<String, Object> x, ObjectOverrideType type) {
        printSubtitle("OTHER COMPARISONS");
        if (type == ObjectOverrideType.NOOVERRIDE) {
            System.out.printf("%-50s%s\n", "new Person(\"Jason\").equals(a):", (new Person("Jason").equals(x.get("a"))));
            System.out.printf("%-50s%s\n", "new Person(\"Jason\") == a:", (new Person("Jason") == x.get("a")));

            System.out.println();
            System.out.printf("%-50s%s\n", "new Person(\"Jason\").equals(b):", (new Person("Jason").equals(x.get("b"))));
            System.out.printf("%-50s%s\n", "new Person(\"Jason\") == b:", (new Person("Jason") == x.get("b")));

            System.out.println();
            System.out.printf("%-50s%s\n", "new Person(\"Jason\").equals(new Person(\"Jason\")):", (new Person("Jason").equals(new Person("Jason"))));
            System.out.printf("%-50s%s\n", "new Person(\"Jason\") == new Person(\"Jason\"):", (new Person("Jason") == new Person("Jason")));

            System.out.println("\n");
        } else if (type == ObjectOverrideType.EQUALS) {
            System.out.printf("%-90s%s\n", "new PersonEqualsOverriden(\"Jason\").equals(a):", (new PersonEqualsOverriden("Jason").equals(x.get("a"))));
            System.out.printf("%-90s%s\n", "new PersonEqualsOverriden(\"Jason\") == a:", (new PersonEqualsOverriden("Jason") == x.get("a")));

            System.out.println();
            System.out.printf("%-90s%s\n", "new PersonEqualsOverriden(\"Jason\").equals(b):", (new PersonEqualsOverriden("Jason").equals(x.get("b"))));
            System.out.printf("%-90s%s\n", "new PersonEqualsOverriden(\"Jason\") == b:", (new PersonEqualsOverriden("Jason") == x.get("b")));

            System.out.println();
            System.out.printf("%-90s%s\n", "new PersonEqualsOverriden(\"Jason\").equals(new PersonEqualsOverriden(\"Jason\")):", (new PersonEqualsOverriden("Jason").equals(new PersonEqualsOverriden("Jason"))));
            System.out.printf("%-90s%s\n", "new PersonEqualsOverriden(\"Jason\") == new PersonEqualsOverriden(\"Jason\"):", (new PersonEqualsOverriden("Jason") == new PersonEqualsOverriden("Jason")));

            System.out.println("\n");

        } else if (type == ObjectOverrideType.HASHCODE) {
            System.out.printf("%-90s%s\n", "new PersonHashCodeOverriden(\"Jason\").equals(a):", (new PersonHashCodeOverriden("Jason").equals(x.get("a"))));
            System.out.printf("%-90s%s\n", "new PersonHashCodeOverriden(\"Jason\") == a:", (new PersonHashCodeOverriden("Jason") == x.get("a")));

            System.out.println();
            System.out.printf("%-90s%s\n", "new PersonHashCodeOverriden(\"Jason\").equals(b):", (new PersonHashCodeOverriden("Jason").equals(x.get("b"))));
            System.out.printf("%-90s%s\n", "new PersonHashCodeOverriden(\"Jason\") == b:", (new PersonHashCodeOverriden("Jason") == x.get("b")));

            System.out.println();
            System.out.printf("%-90s%s\n", "new PersonHashCodeOverriden(\"Jason\").equals(new PersonHashCodeOverriden(\"Jason\")):", (new PersonHashCodeOverriden("Jason").equals(new PersonHashCodeOverriden("Jason"))));
            System.out.printf("%-90s%s\n", "new PersonHashCodeOverriden(\"Jason\") == new PersonHashCodeOverriden(\"Jason\"):", (new PersonHashCodeOverriden("Jason") == new PersonHashCodeOverriden("Jason")));

            System.out.println("\n");

        } else if (type == ObjectOverrideType.EQUALSHASHCODE) {
            System.out.printf("%-100s%s\n", "new PersonEqualsHashCodeOverriden(\"Jason\").equals(a):", (new PersonEqualsHashCodeOverriden("Jason").equals(x.get("a"))));
            System.out.printf("%-100s%s\n", "new PersonEqualsHashCodeOverriden(\"Jason\") == a:", (new PersonEqualsHashCodeOverriden("Jason") == x.get("a")));

            System.out.println();
            System.out.printf("%-100s%s\n", "new PersonEqualsHashCodeOverriden(\"Jason\").equals(b):", (new PersonEqualsHashCodeOverriden("Jason").equals(x.get("b"))));
            System.out.printf("%-100s%s\n", "new PersonEqualsHashCodeOverriden(\"Jason\") == b:", (new PersonEqualsHashCodeOverriden("Jason") == x.get("b")));

            System.out.println();
            System.out.printf("%-100s%s\n", "new PersonEqualsHashCodeOverriden(\"Jason\").equals(new PersonEqualsHashCodeOverriden(\"Jason\")):", (new PersonEqualsHashCodeOverriden("Jason").equals(new PersonEqualsHashCodeOverriden("Jason"))));
            System.out.printf("%-100s%s\n", "new PersonEqualsHashCodeOverriden(\"Jason\") == new PersonEqualsHashCodeOverriden(\"Jason\"):", (new PersonEqualsHashCodeOverriden("Jason") == new PersonEqualsHashCodeOverriden("Jason")));

            System.out.println("\n\n");
        }

    }

}
