import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws ParseException {

        //Simples sem fuso horario para coisas simples
        System.out.println("LocalDate ");

        LocalDate todayComLocalDate = LocalDate.now();
        System.out.println(todayComLocalDate);

        LocalDateTime nowComLocalDateTime = LocalDateTime.now();
        System.out.println(nowComLocalDateTime);

        // com Fuso Horario
        System.out.println();//Quebra de linha
        System.out.println("Instant ");

        Instant nowComInstante = Instant.now();
        System.out.println(nowComInstante);
        Instant nowComInstanteDeLondres = Instant.parse("2022-07-20T01:30:26Z");
        System.out.println(nowComInstanteDeLondres);
        Instant nowComInstanteDeLondresComFusoHorario = Instant.parse("2022-07-20T01:30:26-03:00");
        System.out.println(nowComInstanteDeLondresComFusoHorario);

        System.out.println();//Quebra de linha
        System.out.println("Iso 8601");
        LocalDate iso8601 = LocalDate.parse("2022-07-20");
        System.out.println(iso8601);
        LocalDateTime iso8601b = LocalDateTime.parse("2022-07-20T01:30:26");
        System.out.println(iso8601b);

        //Formatando Data
        System.out.println();//Quebra de linha
        System.out.println("Formatando Data");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate FormatarDataSemHora_E_Minuto = LocalDate.parse("25/10/2022", formatter);
        System.out.println(FormatarDataSemHora_E_Minuto);

        DateTimeFormatter formatterComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime FormatarDataComHora_E_Minuto = LocalDateTime.parse("25/10/2022 01:30:00", formatterComHora);
        System.out.println(FormatarDataComHora_E_Minuto);

        //Formatando Data por dia, mes, ano
        System.out.println();//Quebra de linha
        System.out.println("Formatando Data");
        LocalDate diaMesAno = LocalDate.of(2022,7,20);
        System.out.println(diaMesAno );

        LocalDateTime diaMesAnoTime = LocalDateTime.of(2022,7,20,1,30);
        System.out.println(diaMesAnoTime);


        //Convertendo Data-hora para texto
        System.out.println();//Quebra de linha
        System.out.println("Convertendo Data-hora para texto");

        LocalDate ConvertendoDataLocalDate = LocalDate.parse("2022-07-20");
        LocalDateTime ConvertendoDataLocalDateTime = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant ConvertendoDataInstant = Instant.parse("2022-07-20T01:30:26Z");

        DateTimeFormatter ConvertendoDataFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ConvertendoDataTimeFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter ConvertendoInstantFormatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());


        System.out.println("Convertendo Texto LocalDate = " + ConvertendoDataLocalDate.format(ConvertendoDataFormatador));
        System.out.println("Convertendo Texto LocalDateTime = " + ConvertendoDataLocalDateTime.format(ConvertendoDataTimeFormatador));
        System.out.println("Convertendo Texto Instant = " + ConvertendoInstantFormatador.format(ConvertendoDataInstant));

        //Gravando uma String em Data.
        System.out.println();//Quebra de linha
        System.out.println("Gravando uma String em Data.");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date x1 = new Date();
        Date x2 = Date.from(Instant.parse("2022-07-20T01:30:26Z"));

        Date y1 = sdf1.parse("25/06/2018");
        Date y2 = sdf2.parse("25/06/2018 15:42:07");

        System.out.println("x1: " + sdf2.format(x1));
        System.out.println("y1: " + sdf2.format(y1));
        System.out.println("y2: " + sdf2.format(y2));






    }
}
