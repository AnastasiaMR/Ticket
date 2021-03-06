package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository( );
    private Ticket t1 = new Ticket( 1, 200, "LED", "AAR", 26 );
    private Ticket t2 = new Ticket( 2, 400, "DEM", "LPF", 50 );
    private Ticket t3 = new Ticket( 3, 600, "DEM", "LPF", 50 );
    private Ticket t4 = new Ticket( 4, 400, "LED", "AAR", 26 );
    private Ticket t5 = new Ticket( 5, 800, "LED", "AAR", 26);
    private Ticket t6 = new Ticket(  6, 100, "LED", "AAR", 26 );
    private Ticket t7 = new Ticket( 7, 1400, "MDR", "CVF", 100 );
    private Ticket t8 = new Ticket( 8, 2500, "LED", "AAR", 26 );

    @Test
    void searchSortTicket( ) {
        repository.save( t7 );

        TicketManager manager = new TicketManager( repository );
        Ticket[] expected = new Ticket[]{t7};
        Ticket[] actual = manager.searchBy( "MDR", "CVF" );
        assertArrayEquals( expected, actual );
    }

    @Test
    void searchSortNoTicket( ) {
        TicketManager manager = new TicketManager( repository );
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy( "KRN", "AAR" );
        assertArrayEquals( expected, actual );
    }

    @Test
    void searchAllTickets( ) {
        repository.save( t2 );
        repository.save( t3 );

        TicketManager manager = new TicketManager( repository );
        Ticket[] expected = new Ticket[]{t2, t3};
        Ticket[] actual = manager.searchBy( "DEM", "LPF" );
        Assertions.assertArrayEquals( expected, actual );
    }

    @Test
    void sortTicket( ) {
        repository.save( t1 );
        repository.save( t4 );
        repository.save( t5 );
        repository.save( t6 );
        repository.save( t8 );

        TicketManager manager = new TicketManager( repository );
        Ticket[] actual = manager.searchBy( "LED", "AAR" );
        Ticket[] expected = new Ticket[]{t6, t1, t4, t5, t8};
        assertArrayEquals( expected, actual );
    }
}