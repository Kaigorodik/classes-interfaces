interface Documentable{

    void print();

}

abstract class _Documents implements Documentable {

    static boolean flag_simple = false;
    protected String Name;
    protected String Number;

}

abstract class PersonnelDoc extends _Documents{

    protected String Status;

    public void changeStatus(){
        Status = "Исполнен";
        print();
        System.out.println("Исполнен");
    }

}

class Mail extends _Documents{

    protected String For;
    protected String From;

    static private int numDoc = 0;

    @Override
    public void print() {

        System.out.println(Name + " №"+ Number);
        if(_Documents.flag_simple == false){
            System.out.println("Кому: " + this.For);
            System.out.println("От кого: " + this.From);
        }


    }

    public Mail(String Name, String Number, String For, String From){
        this.Name = Name;
        this.Number = Number;
        this.For = For;
        this.From = From;
    }
}

class Order extends PersonnelDoc{

    protected String employee;
    protected String text_order;


    @Override
    public void print() {

        System.out.println(Name + " №"+ Number);
        if(_Documents.flag_simple == false) {
            System.out.println("Сотрудник: " + employee);
            System.out.println(text_order);
        }
    }

    Order(String Name, String Number, String employee, String text_order){
        Status = "Создан";
        this.Name = Name;
        this.Number = Number;
        this.employee = employee;
        this.text_order = text_order;

    }


}

class Order_delete extends Order{

    protected String text_delete;

    Order_delete(String Name, String Number, String employee, String text_order, String text_delete) {
        super(Name, Number, employee, text_order);
        this.text_delete = text_delete;
    }

    public void print(){

        super.print();
        if(_Documents.flag_simple == false) {
            System.out.println("Причина увольнения: " + text_delete);
        }


    }

}

public class Main {

    public static void main(String[] args) {

        if(args.length > 0 && args[0].equals("-simple")){
            _Documents.flag_simple = true;
        }

        Documentable ex1 = new Mail("Письмо на пожар", "10", "Георгев Ж.Ж.", "Мусоров В.В.");
        ex1.print();
        System.out.println(" ");
        Documentable ex2 = new Order("Приказ на зачисления", "35", "Романов Д.В.", "Прошу зачислить меня в запас");
        ex2.print();
        System.out.println(" ");
        Documentable ex3 = new Order_delete("Приказ на выселение", "31", "Романов Д.В.", "Устроил побои", "Уничтожения частной собственности");
        ex3.print();
        System.out.println(" ");

        PersonnelDoc ex2_2 = (PersonnelDoc) ex2;
        ex2_2.changeStatus();
        System.out.println(" ");
        PersonnelDoc ex3_2 = (PersonnelDoc) ex3;
        ex3_2.changeStatus();
        System.out.println(" ");
    }

}
