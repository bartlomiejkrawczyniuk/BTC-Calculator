package pl.kurs.btccalculator;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BtcCalculatorApplication extends VerticalLayout {

    public static void main(String[] args) {
        SpringApplication.run(BtcCalculatorApplication.class);
    }


//    public static final int EXIT = 0;
//    public static final int CALCULATE = 1;
//
//    public static final LocalDate EARLIEST_DATE = LocalDate.of(2010, 7, 18);
//
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = SpringApplication.run(BtcCalculatorApplication.class, args);
//
//        WithdrawalInterface service = ctx.getBean(WithdrawalInterface.class);
//        GetRateFromUrlInterface rateService = ctx.getBean(GetRateFromUrlInterface.class);
//        Scanner sc = new Scanner(System.in);
//
//        int chosenOption = -1;
//        LocalDate date;
//        String currency;
//        BigDecimal amountOfCash;
//
//        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLUE + "Witaj w kalulatorze potencjalnego zarobku" + ANSI_RESET);
//
//        while (chosenOption != EXIT) {
//            printOptions();
//            try {
//                chosenOption = sc.nextInt();
//                sc.nextLine();
//            } catch (InputMismatchException e) {
//                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Możesz wybrać tylko " + EXIT + " lub " + CALCULATE + ANSI_RESET);
//                sc.nextLine();
//            }
//
//            try {
//                switch (chosenOption) {
//                    case CALCULATE:
//                        System.out.println("Wprowadź datę zakupu BTC w formacie yyyy-MM-dd");
//                        date = LocalDate.parse(sc.nextLine());
//                        if (date.isBefore(EARLIEST_DATE) || date.isAfter(LocalDate.now()))
//                            throw new InvalidDateException(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Niepoprawna data! Możesz wprowadzić datę w przedziale " + EARLIEST_DATE + " do " + LocalDate.now() + ANSI_RESET);
//                        System.out.println("Wprowadź walutę w jakiej byś kupił BTC");
//                        currency = sc.nextLine().toUpperCase();
//                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Cena BTC z dnia " + date + " wynosiła: " + rateService.getHistoricalBtcRateFromUrl(currency, date) + " " + currency + ANSI_RESET);
//                        System.out.println("Wprowadź kwotę za jaką byś kupił BTC");
//                        amountOfCash = sc.nextBigDecimal();
//                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Posiadałbyś " + amountOfCash.divide(rateService.getHistoricalBtcRateFromUrl(currency, date), 2, RoundingMode.HALF_UP) + " Bitcoina" + ANSI_RESET);
//                        BigDecimal withdrawResult = service.withdraw(date, currency, amountOfCash);
//                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Zyskałbyś " + ((withdrawResult.subtract(amountOfCash)).divide(amountOfCash, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)).setScale(1, RoundingMode.HALF_UP) + "%" + ANSI_RESET);
//                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Dzisiaj miałbyś z tego " + new DecimalFormat("###,###.##").format(withdrawResult.setScale(2, RoundingMode.HALF_UP)) + " " + currency + ANSI_RESET);
//                        break;
//                    case EXIT:
//                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "Pamiętaj, warto inwestować w kryptowaluty!" + ANSI_RESET);
//                        break;
//                    default:
//                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Nie znaleziono takiej opcji" + ANSI_RESET);
//                        System.out.println();
//                }
//            } catch (InvalidDateException | InvalidCurrencyNameException | IOException | NoConnectionException e){
//                System.out.println(e.getMessage());
//            } catch (InputMismatchException | DateTimeParseException e) {
//                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Przekazano błędne dane!" + ANSI_RESET);
//                sc.nextLine();
//            }
//        }
//        sc.close();
//
//        ctx.close();
//    }
//
//    private static void printOptions() {
//        System.out.println("Wybierz jedną z opcji:");
//        System.out.println(CALCULATE + " - przelicz ile straciłeś nie inwestując w krypto");
//        System.out.println(EXIT + " - wyjście");
//    }

}
