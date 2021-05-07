package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private Ticket t1 = new Ticket(1, 200, "LED", "AAR", 26);
    private Ticket t2 = new Ticket(2, 400, "DEM", "LPF", 50);
    private Ticket t3 = new Ticket(3, 600, "DEM", "LPF", 50);
    private Ticket t4 = new Ticket(4, 800, "CVF", "BRS", 60);
    private Ticket t5 = new Ticket(5, 1000, "MDR", "AAR", 120);

    @Test
    void searchSortTicket() {
        repository.save(t1);
        repository.save(t2);
        repository.save(t3);
        repository.save(t4);
        repository.save(t5);

        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchBy("MDR", "AAR");
        Ticket[] expected = new Ticket[]{t5};

        assertArrayEquals(actual, expected);
    }

    @Test
    void searchSortNoTicket() {
        repository.save(t1);
        repository.save(t2);
        repository.save(t3);
        repository.save(t4);
        repository.save(t5);

        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchBy("KRN", "AAR");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(actual, expected);
    }

    @Test
    void searchAllTickets() {
        repository.save(t1);
        repository.save(t2);
        repository.save(t3);
        repository.save(t4);
        repository.save(t5);

        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchBy("DEM", "LPF");
        Ticket[] expected = new Ticket[]{t2, t3};

        assertArrayEquals(actual, expected);
    }

}