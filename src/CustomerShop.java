
import javax.swing.JOptionPane;

/**
 *
 * @author Lahndrick Hendricks
 */
public class CustomerShop extends javax.swing.JInternalFrame {

    private String username;
    private String password;
    private ShoppingCart cart;
    private Inventory inv;
    private DatabaseManager db = new DatabaseManager();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Creates new form CustomerShop
     */
    public CustomerShop() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addItemButton = new javax.swing.JButton();
        finaliseCartButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        previousOrdersButton = new javax.swing.JButton();
        removeItemButton = new javax.swing.JButton();
        itemSalesLabel = new javax.swing.JLabel();
        itemsCartLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cart = new ShoppingCart();
        shoppingCartList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        inv = new Inventory();
        String[] items = inv.getStock();
        inventoryList = new javax.swing.JList<>();

        addItemButton.setText("Add item");
        addItemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addItemButtonMouseClicked(evt);
            }
        });

        finaliseCartButton.setText("Finalise cart");
        finaliseCartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finaliseCartButtonMouseClicked(evt);
            }
        });

        signOutButton.setText("Sign out");
        signOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutButtonMouseClicked(evt);
            }
        });

        previousOrdersButton.setText("Previous orders");
        previousOrdersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousOrdersButtonMouseClicked(evt);
            }
        });

        removeItemButton.setText("Remove item");
        removeItemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeItemButtonMouseClicked(evt);
            }
        });

        itemSalesLabel.setText("Items for sale");

        itemsCartLabel.setText("Items in cart total: " + cart.getTotal());

        shoppingCartList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = cart.toString().split("\n");
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(shoppingCartList);

        inventoryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = items;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(inventoryList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(removeItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(finaliseCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemSalesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemsCartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(itemSalesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(itemsCartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finaliseCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addItemButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addItemButtonMouseClicked
        int index = inventoryList.getSelectedIndex();
        Item item = inv.getItem(index);
        cart.addItem(item);
        String[] items = cart.toString().split("\n");
        shoppingCartList.setListData(items);
        itemsCartLabel.setText("Items in cart total: " + cart.getTotal());
        jScrollPane3.setViewportView(shoppingCartList);
    }//GEN-LAST:event_addItemButtonMouseClicked

    private void removeItemButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemButtonMouseClicked
        int index = shoppingCartList.getSelectedIndex();
        cart.removeItem(index);
        String[] items = cart.toString().split("\n");
        shoppingCartList.setListData(items);
        itemsCartLabel.setText("Items in cart total: " + cart.getTotal());
        jScrollPane3.setViewportView(shoppingCartList);
    }//GEN-LAST:event_removeItemButtonMouseClicked

    private void finaliseCartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finaliseCartButtonMouseClicked
        new CartFinaliser(new User(username, password), cart).addTransaction();
        cart.clearCart();
        String[] items = cart.toString().split("\n");
        shoppingCartList.setListData(items);
        itemsCartLabel.setText("Items in cart total: " + cart.getTotal());
        jScrollPane3.setViewportView(shoppingCartList);
    }//GEN-LAST:event_finaliseCartButtonMouseClicked

    private void previousOrdersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousOrdersButtonMouseClicked
        String[] array = db.readFromTransactionLog();
        String output = "";

        for (int x = 0; x < array.length; x++) {
            if (array[x].contains(username)) {
                output += array[x] + "\n";
            }
        }

        if (output.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No previous orders");
        } else {
            JOptionPane.showMessageDialog(this, output);
        }

        this.pack();
    }//GEN-LAST:event_previousOrdersButtonMouseClicked

    private void signOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_signOutButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton finaliseCartButton;
    private javax.swing.JList<String> inventoryList;
    private javax.swing.JLabel itemSalesLabel;
    private javax.swing.JLabel itemsCartLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton previousOrdersButton;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JList<String> shoppingCartList;
    private javax.swing.JButton signOutButton;
    // End of variables declaration//GEN-END:variables
}
