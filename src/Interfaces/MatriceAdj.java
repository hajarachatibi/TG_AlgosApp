package Interfaces;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import Elements.Arret;
import Elements.Configuration;
import Elements.MatriceAdjModel;
import Elements.Sommet;

public class MatriceAdj extends javax.swing.JDialog {
    private int[][] matrice;
    private ArrayList<Sommet> sommets = new ArrayList<>();
    private ArrayList<Arret> arrets = new ArrayList<>();

    public MatriceAdj(java.awt.Frame parent, int[][] matrice, ArrayList<Sommet> sommets) {
        super(parent, true);
        initComponents();
        table_adj.setModel(new MatriceAdjModel(matrice,sommets));
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_adj = new javax.swing.JTable();
        btn_generer = new javax.swing.JButton();
        btn_taille = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_adj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_adj);

        btn_generer.setText("Generer");
        btn_generer.setEnabled(false);
        btn_generer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genererActionPerformed(evt);
            }
        });

        btn_taille.setText("Saisir une nouvelle");
        btn_taille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tailleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_taille)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_generer))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_generer)
                    .addComponent(btn_taille))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tailleActionPerformed
  
        try{
            int nbr_sommets = Integer.parseInt(JOptionPane.showInputDialog("saisi le nombre de sommets!"));
            if(nbr_sommets<=0)return;
            sommets.clear();
            arrets.clear();
            int width = Principal.getInstance().jScrollPane2.getBounds().width;
            int height = Principal.getInstance().jScrollPane2.getBounds().height;
            width -= Configuration.taille_sommet*3;
            height -= Configuration.taille_sommet*3;
            Random r = new Random();
            for (int i = 0; i < nbr_sommets; i++) {
                sommets.add(new Sommet("s"+(i+1), Configuration.coleur_label, Configuration.coleur_sommet, r.nextInt(width), r.nextInt(height)));
            }
            ((MatriceAdjModel)this.table_adj.getModel()).setMatrice(new int[nbr_sommets][nbr_sommets]);
            ((MatriceAdjModel)this.table_adj.getModel()).setSommets(sommets);
            ((MatriceAdjModel)this.table_adj.getModel()).fireTableStructureChanged();
            ((MatriceAdjModel)this.table_adj.getModel()).fireTableDataChanged();
            btn_generer.setEnabled(true);
        }catch(NumberFormatException e){
            return;
        }
        
    }//GEN-LAST:event_btn_tailleActionPerformed
    public boolean check_semitric(){
        for(int i=0;i<matrice.length;i++){
            for(int j=0;j<matrice[i].length;j++){
                if(matrice[i][j]!=matrice[j][i])return true;
            }
        }
        return false;
    }
    public boolean check_pondere(){
        for(int i=0;i<matrice.length;i++){
            for(int j=0;j<matrice[i].length;j++){
                if(matrice[i][j]!=0 && matrice[i][j]!=1)return true;
            }
        }
        return false;
    }
    public boolean check_pondere_positive(){
        for(int i=0;i<matrice.length;i++){
            for(int j=0;j<matrice[i].length;j++){
                if(matrice[i][j]<0)return false;
            }
        }
        return true;
    }
    private void btn_genererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genererActionPerformed
        matrice = ((MatriceAdjModel)this.table_adj.getModel()).getMatrice();
        Configuration.oriente=check_semitric();
        Configuration.pondere=check_pondere();
        Configuration.pondere_positive =check_pondere_positive();
        if(Configuration.pondere){
            for(int i=0;i<matrice.length;i++){
                for(int j=0;j<matrice[i].length;j++){
                    if(matrice[i][j]!=0)arrets.add( new Arret(sommets.get(i),sommets.get(j),Configuration.coleur_arret,matrice[i][j]));
                }
            }
        }else{
            for(int i=0;i<matrice.length;i++){
                for(int j=0;j<matrice[i].length;j++){
                    if(matrice[i][j]!=0)arrets.add( new Arret(sommets.get(i),sommets.get(j),Configuration.coleur_arret));
                }
            }
        }
        Canvas.getInstance().getGraphe().setSommets(sommets);
        Canvas.getInstance().getGraphe().setArrets(arrets);
        Canvas.getInstance().setSelectionne(null);
        Canvas.getInstance().repaint();
    }//GEN-LAST:event_btn_genererActionPerformed


    private javax.swing.JButton btn_generer;
    private javax.swing.JButton btn_taille;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_adj;
}
