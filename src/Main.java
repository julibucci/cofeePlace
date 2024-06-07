/*
import modelo.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

        static Scanner scanner = new Scanner(System.in);

        public static void main (String[]args){

            menuPrincipal();
            scanner.close();

        }

        private static void menuPrincipal () {
            // Primero pregunta si es admin o empleado
            System.out.println("--------------------------------------");
            System.out.println("MENÚ PRINCIPAL:");

            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Administrador.");
            System.out.println("2. Empleado.");
            System.out.println("3. Salir.");
            System.out.println("--------------------------------------");
            int tipoUsuario = scanner.nextInt();

            Stock stock = Gestor.inicializarIngredientesYRecetas(); //Paso necesario (y obligatorio) que se debe hacer antes que cualquier otra cosa

            switch (tipoUsuario) {
                case 1:
                    menuAdmin(stock);
                    break;
                case 2:
                    menuEmpleado(stock);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        private static void menuAdmin (Stock stock){
            char continuar = 's';

            while (continuar == 's') {
                System.out.println("--------------------------------------");
                System.out.println("MENÚ ADMINISTRADOR:");

                System.out.println("1. Mostrar menú de pedidos.");
                System.out.println("2. Anotar pedidos y registrar ventas.");
                System.out.println("3. Gestionar reporte de ventas.");
                System.out.println("4. Gestionar stock.");
                System.out.println("5. Gestionar recetas.");
                System.out.println("6. Volver al menú principal.");
                System.out.println("--------------------------------------");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        Menu menu = new Menu();
                        String mostrarMenu = menu.toString();
                        System.out.println(mostrarMenu);
                        break;
                    case 2:
                        Menu menu2 = new Menu();
                        String mostrarMenu2 = menu2.toString();
                        System.out.println(mostrarMenu2);

                        // Limpia el buffer, sino en la 1ra iteración pide ingresar un pedido pero no deja ingresar el nombre del plato
                        scanner.nextLine();

                        ArrayList<Producto> pedidos = new ArrayList<>();
                        boolean seguirPidiendo = true;

                        while (seguirPidiendo) {
                            System.out.println("Ingrese el nombre del producto que desea pedir (o 'salir' para terminar):");
                            String productoNombre = scanner.nextLine();

                            if (productoNombre.equalsIgnoreCase("salir")) {
                                seguirPidiendo = false;

                            } else {
                                // Se busca el nombre del pedido en el menú inicial
                                Producto producto = menu2.getProductoPorNombre(productoNombre);

                                if (producto != null) {
                                    if (producto.isDisponible())  //Si existe y hay disponibilidad, lo agrega a la lista de pedidos
                                    {
                                        pedidos.add(producto);
                                        System.out.println("Producto agregado al pedido.");

                                    } else {
                                        System.out.println("El producto no está disponible.");
                                    }
                                } else {
                                    System.out.println("El producto no se encuentra en el menú.");
                                }
                            }
                        }

                        if (!pedidos.isEmpty()) {
                            Gestor.anotarPedidos(pedidos);
                            System.out.println("Pedidos anotados y ventas registradas correctamente.");
                        } else {
                            System.out.println("No se han realizado pedidos.");
                        }
                        break;
                    case 3:
                        char subContinuar = 's';

                        while (subContinuar == 's') {
                            System.out.println("--------------------------------------");
                            System.out.println("Elija una opción referente a la gestión del reporte de ventas.");
                            System.out.println("1. Producto más vendido.");
                            System.out.println("2. Producto de mayor ingreso.");
                            System.out.println("3. Cantidad de bebidas vendidas.");
                            System.out.println("4. Cantidad de comidas vendidas.");
                            System.out.println("5. Mostrar productos pedidos.");
                            System.out.println("6. Guardar reporte de ventas en JSON.");
                            System.out.println("7. Leer reporte de ventas en JSON.");
                            System.out.println("8. Volver al menú del administrador.");
                            System.out.println("--------------------------------------");
                            int subOpcion = scanner.nextInt();

                            switch (subOpcion) {
                                case 1:
                                    Producto productoMV = Gestor.obtenerProductoMasVendido();
                                    String productoMasVendido = productoMV.toString();
                                    System.out.println(productoMasVendido);
                                    break;
                                case 2:
                                    Producto productoMI = Gestor.obtenerProductoMayorIngreso();
                                    String productoMayorIngreso = productoMI.toString();
                                    System.out.println(productoMayorIngreso);
                                    break;
                                case 3:
                                    int cantBebidasVendidas = Gestor.obtenerCantidadBebidasVendidas();
                                    System.out.println("Cantidad de bebidas vendidas: " + cantBebidasVendidas);
                                    break;
                                case 4:
                                    int cantComidasVendidas = Gestor.obtenerCantidadComidasVendidas();
                                    System.out.println("Cantidad de comidas vendidas: " + cantComidasVendidas);
                                    break;
                                case 5:
                                    ArrayList<Producto> productos = Gestor.obtenerProductosPedidos();
                                    System.out.println("Productos pedidos:");

                                    for (Producto productoActual : productos) {
                                        System.out.println(productoActual);
                                    }
                                    break;
                                case 6:
                                    Gestor.guardarReporteVentas();
                                    System.out.println("Reporte de ventas guardado correctamente.");
                                    break;
                                case 7:
                                    String infoJsonReporteVentas = Gestor.leerReporteVentas();
                                    System.out.println(infoJsonReporteVentas);
                                    break;
                                case 8:
                                    menuAdmin(stock);
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            System.out.println("Desea volver al sub menú anterior?: (s/n)");
                            subContinuar = scanner.next().charAt(0);
                        }
                        break;
                    case 4:
                        char subContinuar2 = 's';

                        while (subContinuar2 == 's') {
                            System.out.println("--------------------------------------");
                            System.out.println("Elija una opción referente a la gestión del stock.");
                            System.out.println("1. Leer y guardar stock en archivo.");
                            System.out.println("2. Modificar stock.");
                            System.out.println("3. Volver al menú del administrador.");
                            System.out.println("--------------------------------------");
                            int subOpcion = scanner.nextInt();

                            switch (subOpcion) {
                                case 1:
                                    System.out.println("Stock inicial:");
                                    stock = Gestor.guardarYLeerStock();
                                    String stockInicial = stock.toString();
                                    System.out.println(stockInicial);
                                    break;
                                case 2:
                                    System.out.println("Stock actualizado luego de eliminar 50 de 'Lechuga':");
                                    String stockActualizado = Gestor.modificarStock();
                                    System.out.println(stockActualizado);
                                    break;
                                case 3:
                                    menuAdmin(stock);
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            System.out.println("Desea volver al sub menú anterior?: (s/n)");
                            subContinuar2 = scanner.next().charAt(0);
                        }
                        break;
                    case 5:
                        char subContinuar3 = 's';
                        Cocinero cocineroAdmin = new Cocinero("Pedro", "Gomez", 65432134);

                        while (subContinuar3 == 's') {
                            System.out.println("--------------------------------------");
                            System.out.println("Elija una opción referente a la gestión de recetas.");
                            System.out.println("1. Guardar recetas en archivo.");
                            System.out.println("2. Leer recetas.");
                            System.out.println("3. Volver al menú del administrador.");
                            System.out.println("--------------------------------------");
                            int subOpcion = scanner.nextInt();

                            switch (subOpcion) {
                                case 1:
                                    Gestor.guardarRecetas(cocineroAdmin);
                                    System.out.println("Recetas guardadas correctamente.");
                                    break;
                                case 2:
                                    HashMap<String, Receta> recetas = Gestor.leerRecetas(cocineroAdmin);

                                    if (recetas != null && !recetas.isEmpty()) {
                                        System.out.println("Recetas:");

                                        for (Map.Entry<String, Receta> entry : recetas.entrySet()) {
                                            String nombreReceta = entry.getKey();
                                            Receta receta = entry.getValue();
                                            System.out.println("Nombre: " + nombreReceta + ", Receta: " + receta);
                                        }
                                    } else {
                                        System.out.println("No hay recetas disponibles. Primero debe cargarlas utilizando la opción 1 de este sub menú.");
                                    }
                                    break;
                                case 3:
                                    menuAdmin(stock);
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            System.out.println("Desea volver al sub menú anterior?: (s/n)");
                            subContinuar3 = scanner.next().charAt(0);
                        }
                        break;
                    case 6:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

                System.out.println("Desea volver al menú del administrador?: (s/n)");
                continuar = scanner.next().charAt(0);

            }
        }


        public static void menuEmpleado (Stock stock){
            ArrayList<Empleado> empleados = new ArrayList<>();
            empleados.add(new Cocinero("Pedro", "Gomez", 65432134));
            empleados.add(new Mozo("Juan", "Perez", 12345678, 2019));
            empleados.add(new Gerente("Ana", "Lopez", 78912361));

            System.out.println("--------------------------------------");
            System.out.println("MENÚ EMPLEADO:");

            System.out.println("Seleccione el tipo de empleado:");
            System.out.println("1. Cocinero.");
            System.out.println("2. Mozo.");
            System.out.println("3. Gerente.");
            System.out.println("4. Volver al menú principal.");
            System.out.println("--------------------------------------");
            int tipoEmpleado = scanner.nextInt();

            switch (tipoEmpleado) {
                case 1:
                    menuCocinero((Cocinero) empleados.getFirst(), stock);
                    break;
                case 2:
                    menuMozo((Mozo) empleados.get(1), (Cocinero) empleados.getFirst(), stock);
                    break;
                case 3:
                    menuGerente((Gerente) empleados.getLast(), stock);
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }


        private static void menuCocinero (Cocinero cocinero, Stock stock){
            char continuar = 's';

            while (continuar == 's') {
                System.out.println("--------------------------------------");
                System.out.println("Menú Cocinero:");
                System.out.println("1. Guardar recetas en archivo.");
                System.out.println("2. Leer recetas.");
                System.out.println("3. Volver al menú de empleados.");
                System.out.println("--------------------------------------");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        HashMap<String, Receta> recetas = Gestor.getListaRecetas();
                        cocinero.guardarRecetas(recetas);
                        System.out.println("Recetas guardadas correctamente.");
                        break;
                    case 2:
                        cocinero.leerRecetas();
                        HashMap<String, Receta> recetasLeer = cocinero.leerRecetas();

                        if (recetasLeer != null && !recetasLeer.isEmpty()) {
                            System.out.println("Recetas:");

                            for (Map.Entry<String, Receta> entry : recetasLeer.entrySet()) {
                                String nombreReceta = entry.getKey();
                                Receta receta = entry.getValue();
                                System.out.println("Nombre: " + nombreReceta + ", Receta: " + receta);
                            }
                        } else {
                            System.out.println("No hay recetas disponibles. Primero debe cargarlas utilizando la opción 1 de este sub menú.");
                        }
                        break;
                    case 3:
                        menuEmpleado(stock);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

                System.out.println("Desea volver al menú del cocinero?: (s/n)");
                scanner.nextLine();
                continuar = scanner.next().charAt(0);
            }
        }

        private static void menuMozo (Mozo mozo, Cocinero cocinero, Stock stock){
            char continuar = 's';


            while (continuar == 's') {
                System.out.println("--------------------------------------");
                System.out.println("Menú Mozo:");
                System.out.println("1. Tomar y mostrar pedidos.");
                System.out.println("2. Calcular salario del mozo.");
                System.out.println("3. Volver al menú de empleados.");
                System.out.println("--------------------------------------");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        Menu menu2 = new Menu();
                        String mostrarMenu2 = menu2.toString();
                        System.out.println(mostrarMenu2);
                        ArrayList<Comida> comidasPreparadas = new ArrayList<>();

                        scanner.nextLine();

                        // Lista para almacenar los pedidos
                        ArrayList<Producto> pedidos = new ArrayList<>();
                        boolean seguirPidiendo = true;

                        // Iterar para tomar los pedidos del usuario
                        while (seguirPidiendo) {
                            System.out.println("Ingrese el nombre del producto que desea pedir (o 'salir' para terminar):");
                            String productoNombre = scanner.nextLine();

                            if (productoNombre.equalsIgnoreCase("salir")) {
                                seguirPidiendo = false;
                            } else {
                                // Buscar el producto en el menú
                                Producto producto = menu2.getProductoPorNombre(productoNombre);
                                if (producto != null) {
                                    if (producto.isDisponible()) {
                                        pedidos.add(producto);
                                        System.out.println("Producto agregado al pedido.");
                                    } else {
                                        System.out.println("El producto no está disponible.");
                                    }
                                } else {
                                    System.out.println("El producto no se encuentra en el menú.");
                                }
                            }
                        }

                        if (!pedidos.isEmpty()) {

                            // Asignar un nuevo ID a la mesa
                            HashMap<Integer, ArrayList<Producto>> ventasActuales = Gestor.getVentas();
                            int mesaId = ventasActuales.size() + 1;

                            // Se asinga el mozo pasado por parámetro a la mesa creada
                            Mesa mesa = new Mesa(mesaId, mozo);

                            // Crear un nuevo pedido y asignarlo a la mesa
                            Pedido pedido = new Pedido();
                            pedido.crearPedido(mesaId, pedidos);
                            mesa.setMiPedido(pedido);

                            // Anotar el pedido en ventas
                            Gestor.anotarPedidos(pedidos);

                            // El mozo toma el pedido y lo envía al cocinero (pase de manos)
                            comidasPreparadas = mozo.tomarPedidoYenviarAcocinero(mesa, cocinero, stock);

                            System.out.println("Pedidos anotados y pasados al cocinero correctamente.");

                        } else {
                            System.out.println("No se han realizado pedidos.");
                        }

                        System.out.println("Productos pedidos:");

                        for (Producto productoActual : comidasPreparadas) {
                            System.out.println(productoActual);
                        }
                        break;
                    case 2:
                        double salarioMozo = mozo.calcularSalario();
                        System.out.println("El mozo cobra $" + salarioMozo + ".");
                        break;
                    case 3:
                        menuEmpleado(stock);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                System.out.println("Desea volver al menú del mozo?: (s/n)");
                continuar = scanner.next().charAt(0);
            }
        }

        private static void menuGerente (Gerente gerente, Stock stock){
            char continuar = 's';

            while (continuar == 's') {
                System.out.println("--------------------------------------");
                System.out.println("Menú Gerente:");
                System.out.println("1. Leer stock.");
                System.out.println("2. Guardar stock en archivo.");
                System.out.println("3. Volver al menú de empleados.");
                System.out.println("--------------------------------------");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Stock actual:");
                        Stock stockALeer = gerente.leerStock();

                        if (stockALeer == null) {
                            System.out.println("Error: El archivo está vacío.");
                        } else {
                            String informacionStock = stockALeer.toString();
                            System.out.println(informacionStock);
                        }
                        break;
                    case 2:
                        gerente.guardarStock(stock);
                        System.out.println("Stock guardado correctamente.");
                        break;
                    case 3:
                        menuEmpleado(stock);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                System.out.println("¿Desea volver al menú del gerente?: (s/n)");
                scanner.nextLine();
                continuar = scanner.next().charAt(0);
            }
        }
}
*/

import modelo.*;
import modelo.Menu;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Stock stock = Gestor.inicializarIngredientesYRecetas();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::menuPrincipal);
    }

    private static void menuPrincipal() {
        JFrame frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Seleccione el tipo de usuario:");
        userLabel.setBounds(60, 20, 200, 25);
        panel.add(userLabel);

        JButton adminButton = new JButton("Administrador");
        adminButton.setBounds(70, 50, 150, 25);
        adminButton.addActionListener(e -> {
            JFrame adminFrame = new JFrame("Menú Administrador");
            adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            adminFrame.setSize(400, 400);
            JPanel adminPanel = new JPanel();
            adminPanel.setLayout(new GridLayout(7, 1));
            adminFrame.add(adminPanel);

            addAdminButtons(adminPanel, adminFrame);

            adminFrame.setVisible(true);
            adminFrame.setLocationRelativeTo(null);
        });
        panel.add(adminButton);

        JButton empleadoButton = new JButton("Empleado");
        empleadoButton.setBounds(70, 80, 150, 25);
        empleadoButton.addActionListener(e -> {
            JFrame empleadoFrame = new JFrame("Menú Empleado");
            empleadoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            empleadoFrame.setSize(400, 400);
            JPanel empleadoPanel = new JPanel();
            empleadoPanel.setLayout(new GridLayout(5, 1));
            empleadoFrame.add(empleadoPanel);

            addEmpleadoButtons(empleadoPanel, empleadoFrame);

            empleadoFrame.setVisible(true);
            empleadoFrame.setLocationRelativeTo(null);
        });
        panel.add(empleadoButton);

        JButton salirButton = new JButton("Salir");
        salirButton.setBounds(70, 110, 150, 25);
        salirButton.addActionListener(e -> System.exit(0));
        panel.add(salirButton);
    }

    private static void addAdminButtons(JPanel panel, JFrame frame) {
        JButton mostrarMenuButton = new JButton("Mostrar menú de pedidos");
        mostrarMenuButton.addActionListener(e -> {
            Menu menu = new Menu();
            JOptionPane.showMessageDialog(frame, menu.toString());
        });
        panel.add(mostrarMenuButton);

        JButton anotarPedidosButton = new JButton("Anotar pedidos y registrar ventas");
        anotarPedidosButton.addActionListener(e -> {
            Menu menu = new Menu();
            JTextArea textArea = new JTextArea(menu.toString());
            textArea.setEditable(false);

            JPanel pedidosPanel = new JPanel(new BorderLayout());
            pedidosPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

            JTextField pedidoField = new JTextField(20);
            JButton agregarPedidoButton = new JButton("Agregar pedido");
            JButton terminarButton = new JButton("Terminar");
            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Nombre del producto:"));
            inputPanel.add(pedidoField);
            inputPanel.add(agregarPedidoButton);
            inputPanel.add(terminarButton);
            pedidosPanel.add(inputPanel, BorderLayout.SOUTH);

            ArrayList<Producto> pedidos = new ArrayList<>();

            agregarPedidoButton.addActionListener(ae -> {
                String productoNombre = pedidoField.getText();
                Producto producto = menu.getProductoPorNombre(productoNombre);
                if (producto != null) {
                    if (producto.isDisponible()) {
                        pedidos.add(producto);
                        JOptionPane.showMessageDialog(frame, "Producto agregado al pedido.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "El producto no está disponible.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "El producto no se encuentra en el menú.");
                }
                pedidoField.setText("");
            });

            terminarButton.addActionListener(ae -> {
                if (!pedidos.isEmpty()) {
                    Gestor.anotarPedidos(pedidos);
                    JOptionPane.showMessageDialog(frame, "Pedidos anotados y ventas registradas correctamente.");
                } else {
                    JOptionPane.showMessageDialog(frame, "No se han realizado pedidos.");
                }
            });

            JFrame pedidosFrame = new JFrame("Anotar Pedidos");
            pedidosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pedidosFrame.setSize(600, 400);
            pedidosFrame.add(pedidosPanel);
            pedidosFrame.setVisible(true);
            pedidosFrame.setLocationRelativeTo(null);
        });
        panel.add(anotarPedidosButton);

        JButton gestionarReporteButton = new JButton("Gestionar reporte de ventas");
        gestionarReporteButton.addActionListener(e -> {
            JFrame reporteFrame = new JFrame("Gestionar Reporte de Ventas");
            reporteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            reporteFrame.setSize(400, 400);
            JPanel reportePanel = new JPanel();
            reportePanel.setLayout(new GridLayout(9, 1));

            addReporteButtons(reportePanel, reporteFrame);

            reporteFrame.add(reportePanel);
            reporteFrame.setVisible(true);
            reporteFrame.setLocationRelativeTo(null);
        });
        panel.add(gestionarReporteButton);

        JButton gestionarStockButton = new JButton("Gestionar stock");
        gestionarStockButton.addActionListener(e -> {
            JFrame stockFrame = new JFrame("Gestionar Stock");
            stockFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            stockFrame.setSize(400, 400);
            JPanel stockPanel = new JPanel();
            stockPanel.setLayout(new GridLayout(4, 1));

            addStockButtons(stockPanel, stockFrame);

            stockFrame.add(stockPanel);
            stockFrame.setVisible(true);
            stockFrame.setLocationRelativeTo(null);
        });
        panel.add(gestionarStockButton);

        JButton gestionarRecetasButton = new JButton("Gestionar recetas");
        gestionarRecetasButton.addActionListener(e -> {
            JFrame recetasFrame = new JFrame("Gestionar Recetas");
            recetasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            recetasFrame.setSize(400, 400);
            JPanel recetasPanel = new JPanel();
            recetasPanel.setLayout(new GridLayout(4, 1));

            addRecetasButtons(recetasPanel, recetasFrame);

            recetasFrame.add(recetasPanel);
            recetasFrame.setVisible(true);
            recetasFrame.setLocationRelativeTo(null);
        });
        panel.add(gestionarRecetasButton);

        JButton volverButton = new JButton("Volver al menú principal");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }

    private static void addReporteButtons(JPanel panel, JFrame frame) {
        JButton productoMasVendidoButton = new JButton("Producto más vendido");
        productoMasVendidoButton.addActionListener(e -> {
            Producto producto = Gestor.obtenerProductoMasVendido();
            JOptionPane.showMessageDialog(frame, producto.toString());
        });
        panel.add(productoMasVendidoButton);

        JButton productoMayorIngresoButton = new JButton("Producto de mayor ingreso");
        productoMayorIngresoButton.addActionListener(e -> {
            Producto producto = Gestor.obtenerProductoMayorIngreso();
            JOptionPane.showMessageDialog(frame, producto.toString());
        });
        panel.add(productoMayorIngresoButton);

        JButton bebidasVendidasButton = new JButton("Cantidad de bebidas vendidas");
        bebidasVendidasButton.addActionListener(e -> {
            int cantidad = Gestor.obtenerCantidadBebidasVendidas();
            JOptionPane.showMessageDialog(frame, "Cantidad de bebidas vendidas: " + cantidad);
        });
        panel.add(bebidasVendidasButton);

        JButton comidasVendidasButton = new JButton("Cantidad de comidas vendidas");
        comidasVendidasButton.addActionListener(e -> {
            int cantidad = Gestor.obtenerCantidadComidasVendidas();
            JOptionPane.showMessageDialog(frame, "Cantidad de comidas vendidas: " + cantidad);
        });
        panel.add(comidasVendidasButton);

        JButton productosPedidosButton = new JButton("Mostrar productos pedidos");
        productosPedidosButton.addActionListener(e -> {
            ArrayList<Producto> productos = Gestor.obtenerProductosPedidos();
            StringBuilder productosStr = new StringBuilder("Productos pedidos:\n");
            for (Producto producto : productos) {
                productosStr.append(producto.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, productosStr.toString());
        });
        panel.add(productosPedidosButton);

        JButton guardarReporteButton = new JButton("Guardar reporte de ventas en JSON");
        guardarReporteButton.addActionListener(e -> {
            Gestor.guardarReporteVentas();
            JOptionPane.showMessageDialog(frame, "Reporte de ventas guardado correctamente.");
        });
        panel.add(guardarReporteButton);

        JButton leerReporteButton = new JButton("Leer reporte de ventas en JSON");
        leerReporteButton.addActionListener(e -> {
            String reporte = Gestor.leerReporteVentas();
            JOptionPane.showMessageDialog(frame, reporte);
        });
        panel.add(leerReporteButton);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }

    private static void addStockButtons(JPanel panel, JFrame frame) {
        JButton leerYGuardarStockButton = new JButton("Leer y guardar stock en archivo");
        leerYGuardarStockButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Stock inicial:\n" + stock.toString());
            stock = Gestor.guardarYLeerStock();
            JOptionPane.showMessageDialog(frame, "Stock actualizado:\n" + stock.toString());
        });
        panel.add(leerYGuardarStockButton);

        JButton modificarStockButton = new JButton("Modificar stock");
        modificarStockButton.addActionListener(e -> {
            String mensaje = "Stock actualizado luego de eliminar 50 de 'Lechuga':\n" + Gestor.modificarStock();
            JOptionPane.showMessageDialog(frame, mensaje);
        });
        panel.add(modificarStockButton);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }

    private static void addRecetasButtons(JPanel panel, JFrame frame) {
        JButton guardarRecetasButton = new JButton("Guardar recetas en archivo");
        guardarRecetasButton.addActionListener(e -> {
            Cocinero cocinero = new Cocinero("Pedro", "Gomez", 65432134);
            Gestor.guardarRecetas(cocinero);
            JOptionPane.showMessageDialog(frame, "Recetas guardadas correctamente.");
        });
        panel.add(guardarRecetasButton);

        JButton leerRecetasButton = new JButton("Leer recetas");
        leerRecetasButton.addActionListener(e -> {
            Cocinero cocinero = new Cocinero("Pedro", "Gomez", 65432134);
            HashMap<String, Receta> recetas = Gestor.leerRecetas(cocinero);
            if (recetas != null && !recetas.isEmpty()) {
                StringBuilder recetasStr = new StringBuilder("Recetas:\n");
                for (Map.Entry<String, Receta> entry : recetas.entrySet()) {
                    recetasStr.append("Nombre: ").append(entry.getKey()).append(", Receta: ").append(entry.getValue()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, recetasStr.toString());
            } else {
                JOptionPane.showMessageDialog(frame, "No hay recetas disponibles. Primero debe cargarlas utilizando la opción 1 de este submenú.");
            }
        });
        panel.add(leerRecetasButton);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }

    private static void addEmpleadoButtons(JPanel panel, JFrame frame) {
        JButton cocineroButton = new JButton("Cocinero");
        cocineroButton.addActionListener(e -> {
            JFrame cocineroFrame = new JFrame("Menú Cocinero");
            cocineroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cocineroFrame.setSize(400, 400);
            JPanel cocineroPanel = new JPanel();
            cocineroPanel.setLayout(new GridLayout(4, 1));

            addCocineroButtons(cocineroPanel, cocineroFrame);

            cocineroFrame.add(cocineroPanel);
            cocineroFrame.setVisible(true);
            cocineroFrame.setLocationRelativeTo(null);
        });
        panel.add(cocineroButton);

        JButton mozoButton = new JButton("Mozo");
        mozoButton.addActionListener(e -> {
            JFrame mozoFrame = new JFrame("Menú Mozo");
            mozoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mozoFrame.setSize(400, 400);
            JPanel mozoPanel = new JPanel();
            mozoPanel.setLayout(new GridLayout(3, 1));

            addMozoButtons(mozoPanel, mozoFrame);

            mozoFrame.add(mozoPanel);
            mozoFrame.setVisible(true);
            mozoFrame.setLocationRelativeTo(null);
        });
        panel.add(mozoButton);

        JButton gerenteButton = new JButton("Gerente");
        gerenteButton.addActionListener(e -> {
            JFrame gerenteFrame = new JFrame("Menú Gerente");
            gerenteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            gerenteFrame.setSize(400, 400);
            JPanel gerentePanel = new JPanel();
            gerentePanel.setLayout(new GridLayout(3, 1));

            addGerenteButtons(gerentePanel, gerenteFrame);

            gerenteFrame.add(gerentePanel);
            gerenteFrame.setVisible(true);
            gerenteFrame.setLocationRelativeTo(null);
        });
        panel.add(gerenteButton);

        JButton volverButton = new JButton("Volver al menú principal");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }

    private static void addCocineroButtons(JPanel panel, JFrame frame) {
        JButton guardarRecetasButton = new JButton("Guardar recetas en archivo");
        guardarRecetasButton.addActionListener(e -> {
            Cocinero cocinero = new Cocinero("Pedro", "Gomez", 65432134);
            Gestor.guardarRecetas(cocinero);
            JOptionPane.showMessageDialog(frame, "Recetas guardadas correctamente.");
        });
        panel.add(guardarRecetasButton);

        JButton leerRecetasButton = new JButton("Leer recetas");
        leerRecetasButton.addActionListener(e -> {
            Cocinero cocinero = new Cocinero("Pedro", "Gomez", 65432134);
            HashMap<String, Receta> recetas = Gestor.leerRecetas(cocinero);
            if (recetas != null && !recetas.isEmpty()) {
                StringBuilder recetasStr = new StringBuilder("Recetas:\n");
                for (Map.Entry<String, Receta> entry : recetas.entrySet()) {
                    recetasStr.append("Nombre: ").append(entry.getKey()).append(", Receta: ").append(entry.getValue()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, recetasStr.toString());
            } else {
                JOptionPane.showMessageDialog(frame, "No hay recetas disponibles. Primero debe cargarlas utilizando la opción 1 de este submenú.");
            }
        });
        panel.add(leerRecetasButton);

        JButton volverButton = new JButton("Volver al menú de empleados");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }

    private static void addMozoButtons(JPanel panel, JFrame frame) {

        JButton anotarPedidosButton = new JButton("Tomar y mostrar pedidos.");
        anotarPedidosButton.addActionListener(e -> {
            Mozo mozo = new Mozo("Juan", "Perez", 12345678, 2019);
            Menu menu = new Menu();

            JFrame pedidosFrame = new JFrame("Anotar Pedidos");
            pedidosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pedidosFrame.setSize(600, 400);

            JTextArea textArea = new JTextArea(menu.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JTextField pedidoField = new JTextField(20);
            JButton agregarPedidoButton = new JButton("Agregar pedido");
            JButton terminarButton = new JButton("Terminar");
            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Nombre del producto:"));
            inputPanel.add(pedidoField);
            inputPanel.add(agregarPedidoButton);
            inputPanel.add(terminarButton);

            JPanel pedidosPanel = new JPanel(new BorderLayout());
            pedidosPanel.add(scrollPane, BorderLayout.CENTER);
            pedidosPanel.add(inputPanel, BorderLayout.SOUTH);

            ArrayList<Producto> pedidos = new ArrayList<>();

            agregarPedidoButton.addActionListener(ae -> {
                String productoNombre = pedidoField.getText();
                Producto producto = menu.getProductoPorNombre(productoNombre);
                if (producto != null) {
                    if (producto.isDisponible()) {
                        pedidos.add(producto);
                        JOptionPane.showMessageDialog(pedidosFrame, "Producto agregado al pedido.");
                    } else {
                        JOptionPane.showMessageDialog(pedidosFrame, "El producto no está disponible.");
                    }
                } else {
                    JOptionPane.showMessageDialog(pedidosFrame, "El producto no se encuentra en el menú.");
                }
                pedidoField.setText("");
            });

            terminarButton.addActionListener(ae -> {
                if (!pedidos.isEmpty()) {
                    Gestor.anotarPedidos(pedidos);
                    JOptionPane.showMessageDialog(pedidosFrame, "Pedidos anotados y ventas registradas correctamente.");
                } else {
                    JOptionPane.showMessageDialog(pedidosFrame, "No se han realizado pedidos.");
                }
            });

            pedidosFrame.add(pedidosPanel);
            pedidosFrame.setVisible(true);
            pedidosFrame.setLocationRelativeTo(null);
        });
        panel.add(anotarPedidosButton);


        JButton calcularSalarioButton = new JButton("Calcular salario");
        calcularSalarioButton.addActionListener(e -> {
            Mozo mozo = new Mozo("Juan", "Perez", 12345678, 2019);
            double salario = mozo.calcularSalario();
            JOptionPane.showMessageDialog(frame, "El mozo cobra $" + salario + ".");
        });
        panel.add(calcularSalarioButton);

        JButton volverButton = new JButton("Volver al menú de empleados");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }


    private static void addGerenteButtons(JPanel panel, JFrame frame) {
        JButton leerStockButton = new JButton("Leer stock");
        leerStockButton.addActionListener(e -> {
            Gerente gerente = new Gerente("Ana", "Lopez", 78912361);
            Stock stockLeido = gerente.leerStock();
            if (stockLeido != null) {
                JOptionPane.showMessageDialog(frame, "Stock actual:\n" + stockLeido.toString());
            } else {
                JOptionPane.showMessageDialog(frame, "Error: El archivo está vacío.");
            }
        });
        panel.add(leerStockButton);

        JButton guardarStockButton = new JButton("Guardar stock en archivo");
        guardarStockButton.addActionListener(e -> {
            Gerente gerente = new Gerente("Ana", "Lopez", 78912361);
            gerente.guardarStock(stock);
            JOptionPane.showMessageDialog(frame, "Stock guardado correctamente.");
        });
        panel.add(guardarStockButton);

        JButton volverButton = new JButton("Volver al menú de empleados");
        volverButton.addActionListener(e -> frame.dispose());
        panel.add(volverButton);
    }
}
