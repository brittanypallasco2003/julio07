import java.io.*;

public class Principal {

    public static void main(String[] args) {
        String filepath = "datos.dat"; //ruta donde se va a guardar el archivo
        MiClase miObjeto = new MiClase("Brittany", 20);

        try (FileOutputStream fileOutput = new FileOutputStream(filepath);
             ObjectOutputStream obOutput = new ObjectOutputStream(fileOutput)) {
            obOutput.writeObject(miObjeto);
            System.out.println("archivo escrito correctamente");
        } catch (IOException e) {
            throw new RuntimeException(new Exception(e));
        }

        //----LECTURA--
        try (
                FileInputStream fileInput = new FileInputStream(filepath);
             ObjectInputStream objinput = new ObjectInputStream(fileInput);
             )
        {

            MiClase readObject= (MiClase)objinput.readObject();
            System.out.println("El archivo en disco es: "+readObject);
            System.out.println("El nombre  es en disco: "+readObject.getNombre());
            System.out.println("La edad  es en dico: "+readObject.getEdad());

        } catch (IOException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}