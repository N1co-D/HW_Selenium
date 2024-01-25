package secondlesson.HW0;

public class UsefulNotes {
    public static void main(String[] args) {

//        /     Выбирает от корневого узла
//       //     Выбирает узлы от текущего узла, соответствующего выбору, независимо от их местонахождения
//        .     Выбирает текущий узел
//       ..     Выбирает родителя текущего узла
//        @     Выбирает атрибуты

//        /messages         Выбирает корневой элемент сообщений
//        messages/note     Выбирает все элементы note, являющиеся потомками элемента messages
//        //note            Выбирает все элементы note независимо от того, где в документе они находятся
//        messages//note    Выбирает все элементы note, являющиеся потомками элемента messages независимо от того, где они находятся от элемента messages
//        //@date           Выбирает все атрибуты с именем date

//       /messages/note[1]              Выбирает первый элемент note, который является прямым потомком элемента messages.
//       /messages/note[last()]         Выбирает последний элемент note, который является прямым потомком элемента messages.
//       /messages/note[last()-1]       Выбирает предпоследний элемент note, который является прямым потомком элемента messages.
//       /messages/note[position()<3]	Выбирает первые два элемента note, которые являются прямыми потомками элемента messages.
//      //heading[@date]                Выбирает все элементы heading, у которых есть атрибут date
//      //heading[@date="10/01/2008"]	Выбирает все элементы heading, у которых есть атрибут date со значением "10/01/2008"

//        ФУНКЦИИ XPATH
//        --------------------------------------------------------------------------------------------------------------
//        "//div[text()='Hello, World!']"))"            Выбор текстового содержимого
//        "//div[contains(text(),'part of the text')]"  Выбор элемента, содержащего указанный текст
//        "//div[starts-with(text(),'Welcome')]"        Выбор элемента, у которого текст начинается с указанной строки
//   ??   "//div[ends-with(text(),'Welcome')]"          Выбор элемента, у которого текст оканчивается с указанной строки
//        "//div[@id='username']"                       Выбор элемента по значению атрибута
//        "img[starts-with(@src,'logo')]"               Выбор любого рисунка с src-атрибутом, который начинается со значения ‘logo’

//        ОСИ XPATH
//        --------------------------------------------------------------------------------------------------------------
//        ancestor              Выбирает всех предков текущего узла
//        ancestor-or-self      Выбирает всех предков текущего узла и сам текущий узел
//        attribute             Выбирает все атрибуты текущего узла
//        child                 Выбирает всех прямых потомков текущего узла
//        descendant            Выбирает всех потомков текущего узла
//        descendant-or-self    Выбирает всех потомков текущего узла и сам текущий узел
//        following             Выбирает все элементы в документе после закрывающего тега текущего узла
//        following-sibling     Выбирает все элементы одного уровня после текущего узла
//        namespace             Выбирает все узлы пространства имен текущего узла
//        parent                Выбирает родителя текущего узла
//        preceding             Выбирает все узлы, которые появляются перед текущим узлом, за исключением предков, узлов атрибутов и пространства имен
//        preceding-sibling     Выбирает все элементы одного уровня до текущего узла
//        self                  Выбирает текущий узел

//        EXAMPLES XPATH
//        --------------------------------------------------------------------------------------------------------------
//        //div[@class='container']//ancestor::body               Выбирает все предки (включая родителя) узлов <div> с классом 'container' до корневого узла <body>.
//        //p[@id='paragraph']//ancestor-or-self::div             Выбирает текущий узел <p> с id 'paragraph' и все его предки, включая сам узел <p>.
//        //div[@class='example']/attribute::id                   Выбирает все атрибуты id в документе.
//        //ul[@class='menu']/child::li                           Выбирает всех прямых потомков <li> узла <ul> с классом 'menu'.
//        //div[@id='container']//descendant::a                   Выбирает всех потомков <a> узла <div> с id 'container'.
//        //span[@class='highlight']//descendant-or-self::text()  Выбирает текущий узел <span> с классом 'highlight' и все его потомки, включая текстовые узлы.
//        //h2[@id='title']/following::p                          Выбирает все элементы <p>, которые идут после узла <h2> с id 'title'.
//        //li[@class='item']/following-sibling::li               Выбирает все элементы <li>, которые идут на том же уровне после узла <li> с классом 'item'.
//        //namespace::*                                          Выбирает все узлы пространства имен текущего узла.
//        //span[@class='child']/parent::div                      Выбирает родительский узел <div> для узла <span> с классом 'child'.
//        //p[@class='paragraph']/preceding::h3                   Выбирает все узлы <h3>, которые идут перед узлом <p> с классом 'paragraph'.
//        //li[@id='current']/preceding-sibling::li               Выбирает все элементы <li>, которые идут на том же уровне перед узлом <li> с id 'current'.
//        //button[@disabled]/self::button                        Выбирает текущий узел <button> с атрибутом 'disabled'.

    }
}
