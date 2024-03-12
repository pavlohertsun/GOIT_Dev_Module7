package data_readers;

import entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ClientsReaderTest {

    @Test
    void getClientsListFromFile() {
        Client expectedClient = new Client("Pavlo");

        Client actualClient = ClientsReader.getClientsListFromFile("inputFiles/test.txt").get(0);

        Assertions.assertEquals(expectedClient, actualClient);
    }
}