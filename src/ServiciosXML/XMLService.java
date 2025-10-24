package ServiciosXML;

import Modelos.Animales;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLService {

    private static final String XML_FILE = "animales.xml";

    public static void crearXML(Animales animal) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try{
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE)));


                writer.writeStartDocument("1.0");
                writer.writeStartElement("animales");

                    writer.writeStartElement("animal");
                    writer.writeAttribute("id", String.valueOf(animal.getId()));
                    writer.writeStartElement("nombre");
                    writer.writeCharacters(animal.getNombre());
                    writer.writeEndElement();
                    writer.writeStartElement("especie");
                    writer.writeCharacters(animal.getEspecie());
                    writer.writeEndElement();
                    writer.writeStartElement("cantidade");
                    writer.writeCharacters(String.valueOf(animal.getCantidad()));
                    writer.writeEndElement();
                    writer.writeEndElement();

                writer.writeEndElement();
                writer.writeEndDocument();
                writer.flush();
                writer.close();
                System.out.println("Fichero 'animales.xml' creado con éxito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
