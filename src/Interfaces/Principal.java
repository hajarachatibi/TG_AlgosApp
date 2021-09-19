package Interfaces;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTML;

import Interfaces.Menu;
import Interfaces.Principal;
import Algorithmes.BFS;
import Algorithmes.BellmanFord;
import Algorithmes.Coloriage;
import Algorithmes.DFS;
import Algorithmes.Dijikstra;
import Algorithmes.FordFolkersonResiduelle;
import Algorithmes.Kruscal;
import Algorithmes.Prim;
import Algorithmes.Wireshall;
import Elements.Configuration;
import Interfaces.Canvas;
import Interfaces.Principal;
import Interfaces.MatriceAdj;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
	
	public String type;
	public static JTextField Nsommets;
	public static JTextField Naretes;
	public static JTextField densite;
	public static JTextArea algotrace;
	public static JButton btnmatrice ;
	public static JButton btnBFS;
	public static JButton btnDFS;
	public static JButton btnWareshall ;
	public static JButton btnKruskal ;
	public static JButton btnPrim ;
	public static JButton btnDijkstra ;
	public static JButton btnBFord ;
	public static JButton btnresd ;
	public static JButton btnWP ;
	public static JButton btnPDF ;
	public static JButton btnRestart ;
	public static JButton btnGuide ;
	public static JScrollPane jScrollPane2;
	public static JButton jButton7 = new JButton() ;
	public static JLabel jLabel4  = new JLabel()  ;
	public static JLabel jLabel5   = new JLabel() ;
	public static JButton jButton8 = new JButton();
	public static JButton jButton9 = new JButton();
	public static JLabel jLabel6  = new JLabel() ;
	public static JButton jButton2 = new JButton() ;
	public static JLabel jLabel7 = new JLabel() ;
	public static JLabel jLabel8 = new JLabel() ;
	public static JSlider jSlider1 = new JSlider();
    private Interfaces.Menu menu1;




	
    private static Principal instance;
    public static Principal getInstance(){
        if(instance==null){
            instance = new Principal();
        }
        return instance;
    }
    public Principal() {
    	initComponents();
    }
    
    public void setCentrePanel(JPanel p){
        jScrollPane2.setViewportView(p);
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents()
    {
    	
    	this.setBounds(80, 20, 1200, 690);
        menu1 = new Interfaces.Menu();
		
		JPanel pnlinfos = new JPanel();
		pnlinfos.setBackground(new Color(255, 235, 205));
		pnlinfos.setBounds(0, 0, 300, 400);
		pnlinfos.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informations sur votre graphe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setBounds(32, 2, 231, 25);
		pnlinfos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de sommets |V|:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 28, 157, 14);
		pnlinfos.add(lblNewLabel_1);
		
		Nsommets = new JTextField();
		Nsommets.setEditable(false);
		Nsommets.setBounds(177, 23, 86, 25);
		pnlinfos.add(Nsommets);
		Nsommets.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre d'ar\u00EAtes |E|:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 59, 157, 14);
		pnlinfos.add(lblNewLabel_2);
		
		Naretes = new JTextField();
		Naretes.setEditable(false);
		Naretes.setBounds(177, 54, 86, 25);
		pnlinfos.add(Naretes);
		Naretes.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("La densit\u00E9 du graphe d:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 88, 143, 14);
		pnlinfos.add(lblNewLabel_3);
		
		densite = new JTextField();
		densite.setEditable(false);
		densite.setBounds(177, 85, 86, 25);
		pnlinfos.add(densite);
		densite.setColumns(10);
		
		btnmatrice = new JButton("La matrice d'adjacence");
		btnmatrice.setForeground(new Color(178, 34, 34));
		btnmatrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnmatrice.setBounds(50, 113, 184, 25);
		pnlinfos.add(btnmatrice);
        btnmatrice.setEnabled(false);
        btnmatrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_matriceActionPerformed(evt);
            }
        });
		
		JPanel pnlalgos = new JPanel();
		pnlalgos.setBackground(new Color(255, 235, 205));
		pnlalgos.setBounds(896, 0, 300, 690);
		pnlalgos.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Les algorithmes");
		lblNewLabel_5.setFont(new Font("Calibri Light", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_5.setBounds(84, 11, 133, 20);
		pnlalgos.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("**********Parcours du graphe**********");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(21, 42, 257, 14);
		pnlalgos.add(lblNewLabel_6);
		
		btnBFS = new JButton("BFS");
		btnBFS.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBFS.setForeground(new Color(178, 34, 34));
		btnBFS.setBounds(56, 67, 186, 23);
		pnlalgos.add(btnBFS);
        btnBFS.setEnabled(false);
        btnBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bfsActionPerformed(evt);
            }
        });
		
		btnDFS = new JButton("DFS");
		btnDFS.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDFS.setForeground(new Color(178, 34, 34));
		btnDFS.setBounds(56, 101, 186, 23);
		pnlalgos.add(btnDFS);
        btnDFS.setEnabled(false);
        btnDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dfsActionPerformed(evt);
            }
        });
		
		btnWareshall = new JButton("Wareshall");
		btnWareshall.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWareshall.setForeground(new Color(178, 34, 34));
		btnWareshall.setBounds(56, 135, 186, 23);
		pnlalgos.add(btnWareshall);
        btnWareshall.setEnabled(false);
        btnWareshall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_wireshallActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel_7 = new JLabel("********Arbre couvrant minimal********");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(21, 169, 257, 14);
		pnlalgos.add(lblNewLabel_7);
		
		btnKruskal = new JButton("Kruskal");
		btnKruskal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnKruskal.setForeground(new Color(178, 34, 34));
		btnKruskal.setBounds(56, 194, 186, 23);
		pnlalgos.add(btnKruskal);
        btnKruskal.setEnabled(false);
        btnKruskal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kruskalActionPerformed(evt);
            }
        });
        
//*****************************************************************************
        jButton7.setText("arretes");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.setSize(85, 25);
        jButton7.setLocation(10, 222);
        pnlinfos.add(jButton7);
        
        jLabel4.setBackground(new Color(0, 255, 255));
        jLabel4.setOpaque(true);
        jLabel4.setSize(17, 25);
        jLabel4.setLocation(105, 222);
        pnlinfos.add(jLabel4);

        jLabel5.setBackground(new Color(205, 92, 92));
        jLabel5.setOpaque(true);
        jLabel5.setSize(17, 25);
        jLabel5.setLocation(217, 222);
        pnlinfos.add(jLabel5);

        jButton8.setText("sommets");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.setSize(75, 25);
        jButton8.setLocation(132, 222);
        pnlinfos.add(jButton8);

        jButton9.setText("label");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.setSize(72, 24);
        jButton9.setLocation(132, 187);
        pnlinfos.add(jButton9);

        jLabel6.setBackground(new Color(255, 255, 255));
        jLabel6.setOpaque(true);
        jLabel6.setSize(17, 25);
        jLabel6.setLocation(217, 187);
        pnlinfos.add(jLabel6);
        
        jButton2.setText("BFS/DFS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setSize(85, 25);
        jButton2.setLocation(10, 187);
        pnlinfos.add(jButton2);

        jLabel7.setBackground(Color.blue);
        jLabel7.setOpaque(true);
        jLabel7.setSize(17, 25);
        jLabel7.setLocation(105, 187);
        pnlinfos.add(jLabel7);

        jSlider1.setMaximum(5000);
        jSlider1.setValue(1000);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.setSize(102, 25);
        jSlider1.setLocation(161, 149);
        pnlinfos.add(jSlider1);
        
        jLabel8.setSize(122, 25);
        jLabel8.setLocation(0, 151);

        jLabel8.setText("Temps d'annimation:");
        pnlinfos.add(jLabel8);
        
        //*************************************************************************
		
		btnPrim = new JButton("Prim");
		btnPrim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrim.setForeground(new Color(178, 34, 34));
		btnPrim.setBounds(56, 228, 186, 23);
		pnlalgos.add(btnPrim);
        btnPrim.setEnabled(false);
        btnPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel_8 = new JLabel("************Cours chemin************");
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(21, 262, 257, 14);
		pnlalgos.add(lblNewLabel_8);
		
		btnDijkstra = new JButton("Dijkstra");
		btnDijkstra.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDijkstra.setForeground(new Color(178, 34, 34));
		btnDijkstra.setBounds(56, 287, 186, 23);
		pnlalgos.add(btnDijkstra);
		btnDijkstra.setEnabled(false);
		btnDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dijikstraActionPerformed(evt);
            }
        });
		
		btnBFord = new JButton("Bellman-Ford");
		btnBFord.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBFord.setForeground(new Color(178, 34, 34));
		btnBFord.setBounds(56, 321, 186, 23);
		pnlalgos.add(btnBFord);
		btnBFord.setEnabled(false);
		btnBFord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_billmanfordActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel_9 = new JLabel("**********R\u00E9seau de transport**********");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(21, 355, 257, 14);
		pnlalgos.add(lblNewLabel_9);
		
		btnresd = new JButton("Ford Fulkerson");
		btnresd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnresd.setForeground(new Color(178, 34, 34));
		btnresd.setBounds(56, 380, 186, 23);
		pnlalgos.add(btnresd);
		btnresd.setEnabled(false);
		btnresd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fordfolkerson2ActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel_10 = new JLabel("**************Coloriage**************");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(21, 419, 257, 14);
		pnlalgos.add(lblNewLabel_10);
		
		btnWP = new JButton("Welch & Powell");
		btnWP.setEnabled(false);
		btnWP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		           new Thread ( new Coloriage(Canvas.getInstance())).start();

			}
		});
		btnWP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWP.setForeground(new Color(178, 34, 34));
		btnWP.setBounds(56, 444, 186, 23);
		pnlalgos.add(btnWP);
		
		JLabel lblNewLabel_11 = new JLabel("______________________________________");
		lblNewLabel_11.setBounds(10, 478, 268, 14);
		pnlalgos.add(lblNewLabel_11);
		
		btnPDF = new JButton("Exporter PDF");
		btnPDF.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnPDF.setForeground(new Color(0, 128, 128));
		btnPDF.setBounds(84, 503, 133, 23);
		pnlalgos.add(btnPDF);
		btnPDF.setEnabled(false);
		btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exporter_pdfActionPerformed(evt);
            }
        });
		
		btnRestart = new JButton("Recommencer");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        Canvas.instance = null;
		        Principal.getInstance().setCentrePanel(new Menu());
		        
		        Configuration.checkAlgos();
			}
		});
		btnRestart.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnRestart.setForeground(new Color(0, 128, 128));
		btnRestart.setBounds(84, 550, 133, 23);
		pnlalgos.add(btnRestart);
		
		btnGuide = new JButton("Mode d'emploi");
		btnGuide.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnGuide.setForeground(new Color(0, 128, 128));
		btnGuide.setBounds(84, 597, 133, 23);
		pnlalgos.add(btnGuide);
		btnGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mode_emploiActionPerformed(evt);
            }
        });
		
		JPanel pnltrace = new JPanel();
		pnltrace.setBackground(new Color(255, 235, 205));
		pnltrace.setBounds(2, 311, 298, 310);
		//panel.add(pnltrace);
		pnltrace.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 280, 295);
		pnltrace.add(scrollPane);
		
		algotrace = new JTextArea();
		scrollPane.setViewportView(algotrace);
		algotrace.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("La trace de l'algorithme");
		lblNewLabel_4.setBounds(76, 31, 157, 14);
		pnltrace.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Calibri Light", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		
		JLabel lblNewLabel_12 = new JLabel("Editer:");
		lblNewLabel_12.setForeground(new Color(178, 34, 34));
		lblNewLabel_12.setFont(new Font("Calibri Light", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_12.setBounds(10, 138, 59, 20);
		pnlinfos.add(lblNewLabel_12);
				
		//************************************************************************************************************

		JScrollPane jscrollAlgo = new JScrollPane(pnlalgos);
		jscrollAlgo.setPreferredSize(new Dimension(60, 0));
		jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(menu1);
		JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jScrollPane2, jscrollAlgo);
		getContentPane().add(jSplitPane2);
		jSplitPane2.setResizeWeight(0.7);
		JSplitPane jSplitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnlinfos, pnltrace);
		jSplitPane3.setPreferredSize(new Dimension(300, 0));
		jSplitPane3.setResizeWeight(0.4);
		JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jSplitPane3, jSplitPane2);
		getContentPane().add(jSplitPane1);

		//************************************************************************************************************
        

    }

	public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal.getInstance().setCentrePanel(new Menu());
                Principal.getInstance().setVisible(true);
            }
        });
	}
    
	
    private void btn_matriceActionPerformed(java.awt.event.ActionEvent evt) {
        new MatriceAdj(this, Canvas.getInstance().getGraphe().matriceAdj(), Canvas.getInstance().getGraphe().getSommets()).setVisible(true);

    }

    private void btn_bfsActionPerformed(java.awt.event.ActionEvent evt) {
        if(Canvas.getInstance().getSelectionne()!=null){
            new Thread(new BFS(Canvas.getInstance().getGraphe(), Canvas.getInstance().getSelectionne())).start();
        }else{
            
        }
        
    }

    private void btn_dfsActionPerformed(java.awt.event.ActionEvent evt) {
        if(Canvas.getInstance().getSelectionne()!=null){
            new Thread(new DFS(Canvas.getInstance().getGraphe(), Canvas.getInstance().getSelectionne())).start();
        }else{
            
        }
    }

    private void btn_primActionPerformed(java.awt.event.ActionEvent evt) {
        new Thread(new Prim(Canvas.getInstance().getGraphe())).start();
    }

    private void btn_kruskalActionPerformed(java.awt.event.ActionEvent evt) {
        new Thread(new Kruscal(Canvas.getInstance().getGraphe())).start();
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        JColorChooser jcc = new JColorChooser(Configuration.coleur_arret);
        JColorChooser.createDialog(Principal.getInstance(), "choisir une coleur", true, jcc, null, null).setVisible(true);
        Configuration.coleur_arret = jcc.getColor();
        jLabel4.setBackground(jcc.getColor());
        if(Canvas.getInstance()!=null)Canvas.getInstance().getGraphe().repaint();
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        JColorChooser jcc = new JColorChooser(Configuration.coleur_sommet);
        JColorChooser.createDialog(Principal.getInstance(), "choisir une coleur", true, jcc, null, null).setVisible(true);
        Configuration.coleur_sommet = jcc.getColor();
        jLabel5.setBackground(jcc.getColor());
        if(Canvas.getInstance()!=null)Canvas.getInstance().getGraphe().repaint();
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        JColorChooser jcc = new JColorChooser(Configuration.coleur_label);
        JColorChooser.createDialog(Principal.getInstance(), "choisir une coleur", true, jcc, null, null).setVisible(true);
        Configuration.coleur_label = jcc.getColor();
        jLabel6.setBackground(jcc.getColor());
        if(Canvas.getInstance()!=null)Canvas.getInstance().getGraphe().repaint();
    }

    private void btn_wireshallActionPerformed(java.awt.event.ActionEvent evt) {
        new Thread(new Wireshall(Canvas.getInstance().getGraphe())).start();
    }


    private void btn_dijikstraActionPerformed(java.awt.event.ActionEvent evt) {
        if(Canvas.getInstance().getSelectionne()!=null){
            new Thread(new Dijikstra(Canvas.getInstance().getGraphe(), Canvas.getInstance().getSelectionne())).start();
        }else{
            
        }
    }

    private void btn_exporter_pdfActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setFileFilter(new FileNameExtensionFilter("Fichiers pdf", new String[]{"pdf","PDF"}));
        String chemin=null;
        
        if(file_chooser.showDialog(Principal.instance, "Exporter vers")==0) {
	        if(file_chooser.getSelectedFile().exists()) {       	
	        	if(JOptionPane.showConfirmDialog(Principal.instance, "Voulez vous vraiments ecraser lecontenu du fichier!!", "Fichier deja Exist!!!", JOptionPane.WARNING_MESSAGE )!=0)return;
	        	chemin = file_chooser.getSelectedFile().getAbsolutePath();
	        }
	        if(chemin==null)chemin = file_chooser.getSelectedFile().getAbsolutePath()+".pdf";
            try {
                FileOutputStream fos = new FileOutputStream(new File(chemin));
                Document document = new Document();
                PdfWriter.getInstance(document, fos);
                document.open();
                document.add(new Paragraph("Rapport d'application d'algorithme: "+Configuration.current_algo.getNom()));
                File fichier_tmp = File.createTempFile("tmp", ".png");
                BufferedImage bf=Configuration.images.get(0);
                ImageIO.write(bf, "png", fichier_tmp);
                document.add(new Paragraph("Graphe initial: "));
                document.add(Image.getInstance(fichier_tmp.toURI().toURL()));
                document.add(new Paragraph("Trace: "));
                document.add(new Paragraph(Configuration.current_algo.getTrace().toString()));
                document.add(new Paragraph("Trace - image pour chaque etape: "));
                for(int i=1;i<Configuration.images.size();i++){
                    ImageIO.write(Configuration.images.get(i), "png", fichier_tmp);
                    document.add(Image.getInstance(fichier_tmp.toURI().toURL()));
                }
                document.close();
            } catch (DocumentException | FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
              
                
        }
        
    }

    private void btn_mode_emploiActionPerformed(java.awt.event.ActionEvent evt) {
    	String url="guide\\mode_emploi.html";
    	File htmlFile = new File(url);
    	try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        JColorChooser jcc = new JColorChooser(Configuration.coleur_label);
        JColorChooser.createDialog(Principal.getInstance(), "choisir une coleur", true, jcc, null, null).setVisible(true);
        Configuration.coleur_parcour = jcc.getColor();
        jLabel7.setBackground(jcc.getColor());
        if(Canvas.getInstance()!=null)Canvas.getInstance().getGraphe().repaint();
    }

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {
        Configuration.sleep_time = jSlider1.getValue();
    }//GEN-LAST:event_jSlider1StateChanged

    private void btn_billmanfordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_billmanfordActionPerformed
        if(Canvas.getInstance().getSelectionne()!=null){
            new Thread(new BellmanFord(Canvas.getInstance().getGraphe(), Canvas.getInstance().getSelectionne())).start();
        }else{
            
        }
    }//GEN-LAST:event_btn_billmanfordActionPerformed

    private void btn_fordfolkerson2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fordfolkerson2ActionPerformed
        new Thread(new FordFolkersonResiduelle(Canvas.getInstance().getGraphe(), Canvas.getInstance().getGraphe().getS(),Canvas.getInstance().getGraphe().getP())).start();
    }//GEN-LAST:event_btn_fordfolkerson2ActionPerformed


	}

