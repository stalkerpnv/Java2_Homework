/**
 * Java. Level 2* Lesson 2. Homework 2.
 *
 * @author Petrov Nikolay
 * @version dated Dec 26, 2018
 */

/*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера
необходимо бросить исключение MyArraySizeException.
 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива
 преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
 с детализацией в какой именно ячейке лежат неверные данные.
 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 и вывести результат расчета.*/

public class Homework2 {
    private static int sumArray(String[][] strArray)throws ArrayIndexOutOfBoundsException, NumberFormatException{
        int sum = 0;
        if(strArray.length!=4 && strArray[0].length!=4){
            throw  new ArrayIndexOutOfBoundsException();
        }
        else{
            for(int i = 0; i<strArray.length; i++){
                for(int j = 0; j<strArray[i].length; j++){
                    sum = sum + Integer.valueOf(strArray[i][j]);
                }
            }
        }
        return sum;
    }
    public static void main(String[]args){
        try{
            String [][]strArray ={
                    {"1","2","3","4"},
                    {"5","6","7","8"}
                    };
            System.out.println("Сумма элементов массива равна = " + sumArray(strArray));
        }
        catch(ArrayIndexOutOfBoundsException arri){
           System.out.println("Выход за пределы массива " + arri);
        }
        catch ( NumberFormatException nume){
            System.out.println("Несоответствие типа элемента массива " + nume);
        }
    }
}
