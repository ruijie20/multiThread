package Chapter2.Section3;

public class Main {
    public static void main(String[] args){
        Cinema cinema = new Cinema();

        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread ticketOffice1Thread = new Thread(ticketOffice1, "TicketOffice1");

        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread ticketOffice2Thread = new Thread(ticketOffice2, "TicketOffice2");

        ticketOffice1Thread.start();
        ticketOffice2Thread.start();

        try {
            ticketOffice1Thread.join();
            ticketOffice2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room 1 Vacancies %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies %d\n", cinema.getVacanciesCinema2());
    }
}
