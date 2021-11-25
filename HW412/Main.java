import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> empAccounting = new ArrayList<>(5); // данные о сотруднике для занесения в employees
        List<Employee> employees = new ArrayList<>(5); // список сотрудников
        String surname;
        String name;

        while(true) {
            System.out.println("Введите информацию о сотруднике (фамилия, имя, возраст, пол, образование, должность, отдел):\n");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            } else {
                for (int i = 0; i < input.split(" ").length; i++) {
                    empAccounting.add(input.split(" ")[i]);
                }
                Employee emp = new Employee(empAccounting);
                empAccounting.clear();
                employees.add(emp);
            }
        }

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        while(true) {

            System.out.println("Введите фамилию и имя работника для поиска или end для выхода");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                String[] inputArr = input.split(" ");
                surname = inputArr[0];
                name = inputArr[1];
            }

            searchBySurname(surname, name, employees);
            System.out.println("Введите табельный номер работника, для которого хотите изменить данные или end для выхода");
            input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            editEmployee(Integer.parseInt(input) - 1, employees, scanner);
        }

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    // такая реализация, чтобы менять не первого найденного сотрудника, а выбирать среди найденных, вдруг полные тёзки
    // а уникального идентификатора (коим должжен быть табельный номер), у нас нет по факту
    static void searchBySurname(String surname, String name, List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(name) && employees.get(i).getLastName().equals(surname)) {
                System.out.println((i + 1) + ". " + employees.get(i).toString());
            }
        }
    }

    static void editEmployee(int number, List<Employee> employees, Scanner scanner) {
        System.out.println("Введите фамилию или '-' для пропуска поля");
        String input = scanner.nextLine();
        if (input.equals("-")) {
            employees.get(number).setLastName(employees.get(number).getLastName());
        } else {
            employees.get(number).setLastName(input);
        }
        System.out.println("Введите имя или '-' для пропуска поля");
        input = scanner.nextLine();
        if (input.equals("-")) {
            employees.get(number).setFirstName(employees.get(number).getFirstName());
        } else {
            employees.get(number).setFirstName(input);
        }
        // и так для оставшихся пяти полей
    }
}
