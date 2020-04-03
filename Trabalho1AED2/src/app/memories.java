// // do {
// //     opcao = menu();
// //     switch (opcao) {
// //         case '1':
// //         System.out.println("Inserindo no inicio...");
// //         p = new TBlocos();
// //         System.out.println("Inserir valor");
// //         p.setValor(scan.nextInt());
// //         list.inserirPrimeiro(p);
// //             break;
// //         case '2':
// //         System.out.println("Inserindo no Final...");
// //         p  = new TBlocos();
// //         System.out.println("Inserir Idade");
// //         p.setValor(scan.nextInt());
// //         list.inserirUltimo(p);
// //             break;
// //         case '3':
// //         if (list.eVazia()) {
// //             System.out.println("A Lista é Vazia.");
// //         } else {
// //             System.out.println("Localizando Pessoa .. \nDigite o Nome ");
// //             int valor = scan.nextInt();
// //             if (list.pesquisarNo(valor) == null) {
// //                 System.out.println("A Pessoa procurada não está na lista!");
// //             }else{
// //                 System.out.println("::::: ENCONTRADO :::::");
// //                 System.out.println(list.pesquisarNo(valor));
// //                 System.out.println("::::::::::::::::::::::");
// //             }
// //         }
// //             break;
// //         case '4':
// //         System.out.println("Entrou");
// //         if (list.eVazia()) {
// //             System.out.println("A Lista está Vazia");
// //         } else {
// //             System.out.println("Excluir uma Pessoa\nDigite o nome");
// //             int nome = scan.nextInt();
// //             if (list.removerNo(nome)) {
// //                 System.out.println(nome + " Removido Com Sucesso!");
// //             } else {
// //                 System.out.println("Não Foi Possivel Remover: " + nome);
// //             }
// //         }
// //             break;
// //         case '5':
// //         System.out.println("-----------------------------------------");
// //         System.out.println("Lista: "+list.imprmirLista());
// //         System.out.println("-----------------------------------------");
// //             break;
// //         case '6':
// //         System.out.println("A Lista tem : "+list.getQtdNo()+ " de Pessoas!");
// //             break;
// //         case '7':
// //         System.out.println("Obrigado por usar esse software");
// //             break;

// //         default:
// //         System.out.println("Opção Invalida");
// //             break;
// //     }
// // } while (opcao != '7');
// // System.exit(0);
// //------------------------------------------------------
// boolean isclean = false;
//         while (isclean != true) {
//             for (int i = 0; i < table.length; i++) {
//                 System.out.println(i);
                
//                 if (!table[i].isEmpity()) {
                    
//                     if (table[i].getLast().getTb().getValor() == val) {
//                         System.out.println("hekyeah " + " " + table[i].getFirst().getTb().getValor());
                        
//                         // System.out.println("B: "+table[i].getFirst().getTb().getValor()+" i:"+i);
//                         if (table[i].search(val)) {
                            
//                             // System.out.println(i + " "+"Ultimo: "+table[i].getLast().getTb().getValor());
//                             TBlocos tb = new TBlocos(table[i].getLast().getTb().getValor());
//                             table[i].insertFirst(tb);
//                             // System.out.println(i + " " + "Ultimp: " + table[i].getLast().getTb().getValor() + " Valor " + val);
//                             // System.out.println("tablet: "+table[i].getLast().getTb().getValor());
//                             table[i].removeNode(table[i].getLast().getTb().getValor());
//                         }

//                     } else {
//                         // System.out.println("Chamou!");
//                         isclean = true;
//                     }
//                 }
//             }

//         }