package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author MikeBednarski
 * Version 1: September 24, 2019
 * This is the GUI frame for the Disney Emoji Blitz category chooser. Given up to 3 categories
 * or one box and 2 categories, this will give what emojis fulfill the categories chosen.
 * 
 */
public class DEBCatFrame extends javax.swing.JFrame implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form DEBCatFrame
	 */
	public DEBCatFrame() {
		categories = new ArrayList<String>();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */

	private void initComponents() {

		buttonGroup = new javax.swing.ButtonGroup();
		GroupLabel = new javax.swing.JLabel();
		Aladdin = new javax.swing.JCheckBox();
		Alice_in_Wonderland = new javax.swing.JCheckBox();
		Animal = new javax.swing.JCheckBox();
		Bearded = new javax.swing.JCheckBox();
		Beauty_and_the_Beast = new javax.swing.JCheckBox();
		BigEared = new javax.swing.JCheckBox();
		Blue = new javax.swing.JCheckBox();
		Boys = new javax.swing.JCheckBox();
		Cat_or_Dog = new javax.swing.JCheckBox();
		Coco = new javax.swing.JCheckBox();
		Fairies = new javax.swing.JCheckBox();
		Finding_NemoDory = new javax.swing.JCheckBox();
		Flying = new javax.swing.JCheckBox();
		FourLegged = new javax.swing.JCheckBox();
		Frozen = new javax.swing.JCheckBox();
		Girls = new javax.swing.JCheckBox();
		Green = new javax.swing.JCheckBox();
		Hatwearing = new javax.swing.JCheckBox();
		Haunted_Mansion = new javax.swing.JCheckBox();
		Hercules = new javax.swing.JCheckBox();
		Inside_Out = new javax.swing.JCheckBox();
		Jewelry = new javax.swing.JCheckBox();
		Mickey_and_Friends = new javax.swing.JCheckBox();
		Moana = new javax.swing.JCheckBox();
		Monsters_Inc = new javax.swing.JCheckBox();
		Mulan = new javax.swing.JCheckBox();
		Nightmare_Before_Christmas = new javax.swing.JCheckBox();
		Orange = new javax.swing.JCheckBox();
		Outer_Space = new javax.swing.JCheckBox();
		Pirates_of_the_Caribbean = new javax.swing.JCheckBox();
		Pixar = new javax.swing.JCheckBox();
		Pocahontas = new javax.swing.JCheckBox();
		Prince = new javax.swing.JCheckBox();
		Princess_and_the_Frog = new javax.swing.JCheckBox();
		Princesses = new javax.swing.JCheckBox();
		Purple = new javax.swing.JCheckBox();
		Red = new javax.swing.JCheckBox();
		Rescue_Rangers = new javax.swing.JCheckBox();
		Robin_Hood = new javax.swing.JCheckBox();
		Scary = new javax.swing.JCheckBox();
		Sleeping_Beauty = new javax.swing.JCheckBox();
		Snow_White = new javax.swing.JCheckBox();
		Star_Wars = new javax.swing.JCheckBox();
		Tangled = new javax.swing.JCheckBox();
		The_Emperors_New_Groove = new javax.swing.JCheckBox();
		The_Incredibles = new javax.swing.JCheckBox();
		The_Jungle_Book = new javax.swing.JCheckBox();
		The_Lion_King = new javax.swing.JCheckBox();
		The_Little_Mermaid = new javax.swing.JCheckBox();
		The_Muppets = new javax.swing.JCheckBox();
		Toy_Story = new javax.swing.JCheckBox();
		Underwater = new javax.swing.JCheckBox();
		Up = new javax.swing.JCheckBox();
		Winnie_the_Pooh = new javax.swing.JCheckBox();
		WreckIt_Ralph = new javax.swing.JCheckBox();
		Yellow = new javax.swing.JCheckBox();
		Zootopia = new javax.swing.JCheckBox();
		BoxLabel = new javax.swing.JLabel();
		ExecuteButton = new javax.swing.JButton();
		Silver = new javax.swing.JRadioButton();
		Gold = new javax.swing.JRadioButton();
		Rainbow = new javax.swing.JRadioButton();
		Series = new javax.swing.JRadioButton();
		Villain = new javax.swing.JRadioButton();
		None = new javax.swing.JRadioButton();
		Information = new javax.swing.JLabel();

		BoxPanel = new javax.swing.JPanel();
		CatPanel = new javax.swing.JPanel();
		setResizable(false);

		CatPanel.setBackground(new java.awt.Color(132, 112, 187));
		BoxPanel.setBackground(new java.awt.Color(132, 112, 187));

		buttonGroup.add(Silver);
		buttonGroup.add(Gold);
		buttonGroup.add(Rainbow);
		buttonGroup.add(Series);
		buttonGroup.add(Villain);
		buttonGroup.add(None);
		None.setSelected(true);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Disney Emoji Blitz Categories");
		getContentPane().setBackground(new java.awt.Color(132, 112, 187));

		JScrollPane CatScroll = new JScrollPane(CatPanel);

		CatPanel.setLayout(new java.awt.GridLayout(0, 6, 0, 0));

		GroupLabel.setForeground(new java.awt.Color(211, 211, 211));
		GroupLabel.setText("Groups");
		GroupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		Aladdin.setForeground(new java.awt.Color(255, 255, 255));
		Aladdin.setText("Aladdin");
		Aladdin.setName("Aladdin");
		Aladdin.addItemListener(this);
		CatPanel.add(Aladdin);

		Alice_in_Wonderland.setForeground(new java.awt.Color(255, 255, 255));
		Alice_in_Wonderland.setText("Alice in Wonderland");
		Alice_in_Wonderland.setName("Alice_in_Wonderland");
		Alice_in_Wonderland.addItemListener(this);
		CatPanel.add(Alice_in_Wonderland);

		Animal.setForeground(new java.awt.Color(255, 255, 255));
		Animal.setText("Animal");
		Animal.setName("Animal");
		Animal.addItemListener(this);
		CatPanel.add(Animal);

		Bearded.setForeground(new java.awt.Color(255, 255, 255));
		Bearded.setText("Bearded");
		Bearded.setName("Bearded");
		Bearded.addItemListener(this);
		CatPanel.add(Bearded);

		Beauty_and_the_Beast.setForeground(new java.awt.Color(255, 255, 255));
		Beauty_and_the_Beast.setText("Beauty and the Beast");
		Beauty_and_the_Beast.setName("Beauty_and_the_Beast");
		Beauty_and_the_Beast.addItemListener(this);
		CatPanel.add(Beauty_and_the_Beast);

		BigEared.setForeground(new java.awt.Color(255, 255, 255));
		BigEared.setText("Big Eared");
		BigEared.setName("BigEared");
		BigEared.addItemListener(this);
		CatPanel.add(BigEared);

		Blue.setForeground(new java.awt.Color(255, 255, 255));
		Blue.setText("Blue");
		Blue.setName("Blue");
		Blue.addItemListener(this);
		CatPanel.add(Blue);

		Boys.setForeground(new java.awt.Color(255, 255, 255));
		Boys.setText("Boys");
		Boys.setName("Boys");
		Boys.addItemListener(this);
		CatPanel.add(Boys);

		Cat_or_Dog.setForeground(new java.awt.Color(255, 255, 255));
		Cat_or_Dog.setText("Cat or Dog");
		Cat_or_Dog.setName("Cat_or_Dog");
		Cat_or_Dog.addItemListener(this);
		CatPanel.add(Cat_or_Dog);

		Coco.setForeground(new java.awt.Color(255, 255, 255));
		Coco.setText("Coco");
		Coco.setName("Coco");
		Coco.addItemListener(this);
		CatPanel.add(Coco);
		
		Fairies.setForeground(new java.awt.Color(255, 255, 255));
		Fairies.setText("Fairies");
		Fairies.setName("Fairies");
		Fairies.addItemListener(this);
		CatPanel.add(Fairies);

		Finding_NemoDory.setForeground(new java.awt.Color(255, 255, 255));
		Finding_NemoDory.setText("Finding Nemo/Dory");
		Finding_NemoDory.setName("Finding_NemoDory");
		Finding_NemoDory.addItemListener(this);
		CatPanel.add(Finding_NemoDory);

		Flying.setForeground(new java.awt.Color(255, 255, 255));
		Flying.setText("Flying");
		Flying.setName("Flying");
		Flying.addItemListener(this);
		CatPanel.add(Flying);

		FourLegged.setForeground(new java.awt.Color(255, 255, 255));
		FourLegged.setText("Four Legged");
		FourLegged.setName("FourLegged");
		FourLegged.addItemListener(this);
		CatPanel.add(FourLegged);

		Frozen.setForeground(new java.awt.Color(255, 255, 255));
		Frozen.setText("Frozen");
		Frozen.setName("Frozen");
		Frozen.addItemListener(this);
		CatPanel.add(Frozen);

		Girls.setForeground(new java.awt.Color(255, 255, 255));
		Girls.setText("Girls");
		Girls.setName("Girls");
		Girls.addItemListener(this);
		CatPanel.add(Girls);

		Green.setForeground(new java.awt.Color(255, 255, 255));
		Green.setText("Green");
		Green.setName("Green");
		Green.addItemListener(this);
		CatPanel.add(Green);

		Hatwearing.setForeground(new java.awt.Color(255, 255, 255));
		Hatwearing.setText("Hat Wearing");
		Hatwearing.setName("Hatwearing");
		Hatwearing.addItemListener(this);
		CatPanel.add(Hatwearing);

		Haunted_Mansion.setForeground(new java.awt.Color(255, 255, 255));
		Haunted_Mansion.setText("Haunted Mansion");
		Haunted_Mansion.setName("Haunted_Mansion");
		Haunted_Mansion.addItemListener(this);
		CatPanel.add(Haunted_Mansion);

		Hercules.setForeground(new java.awt.Color(255, 255, 255));
		Hercules.setText("Hercules");
		Hercules.setName("Hercules");
		Hercules.addItemListener(this);
		CatPanel.add(Hercules);

		Inside_Out.setForeground(new java.awt.Color(255, 255, 255));
		Inside_Out.setText("Inside Out");
		Inside_Out.setName("Inside_Out");
		Inside_Out.addItemListener(this);
		CatPanel.add(Inside_Out);

		Jewelry.setForeground(new java.awt.Color(255, 255, 255));
		Jewelry.setText("Jewelry");
		Jewelry.setName("Jewelry");
		Jewelry.addItemListener(this);
		CatPanel.add(Jewelry);

		Mickey_and_Friends.setForeground(new java.awt.Color(255, 255, 255));
		Mickey_and_Friends.setText("Mickey and Friends");
		Mickey_and_Friends.setName("Mickey_and_Friends");
		Mickey_and_Friends.addItemListener(this);
		CatPanel.add(Mickey_and_Friends);

		Moana.setForeground(new java.awt.Color(255, 255, 255));
		Moana.setText("Moana");
		Moana.setName("Moana");
		Moana.addItemListener(this);
		CatPanel.add(Moana);

		Monsters_Inc.setForeground(new java.awt.Color(255, 255, 255));
		Monsters_Inc.setText("Monsters, Inc.");
		Monsters_Inc.setName("Monsters_Inc");
		Monsters_Inc.addItemListener(this);
		CatPanel.add(Monsters_Inc);

		Mulan.setForeground(new java.awt.Color(255, 255, 255));
		Mulan.setText("Mulan");
		Mulan.setName("Mulan");
		Mulan.addItemListener(this);
		CatPanel.add(Mulan);

		Nightmare_Before_Christmas.setForeground(new java.awt.Color(255, 255, 255));
		Nightmare_Before_Christmas.setText("Nightmare Before Christmas");
		Nightmare_Before_Christmas.setName("Nightmare_Before_Christmas");
		Nightmare_Before_Christmas.addItemListener(this);
		CatPanel.add(Nightmare_Before_Christmas);

		Orange.setForeground(new java.awt.Color(255, 255, 255));
		Orange.setText("Orange");
		Orange.setName("Orange");
		Orange.addItemListener(this);
		CatPanel.add(Orange);

		Outer_Space.setForeground(new java.awt.Color(255, 255, 255));
		Outer_Space.setText("Outer Space");
		Outer_Space.setName("Outer_Space");
		Outer_Space.addItemListener(this);
		CatPanel.add(Outer_Space);

		Pirates_of_the_Caribbean.setForeground(new java.awt.Color(255, 255, 255));
		Pirates_of_the_Caribbean.setText("Pirates of the Caribbean");
		Pirates_of_the_Caribbean.setName("Pirates_of_the_Caribbean");
		Pirates_of_the_Caribbean.addItemListener(this);
		CatPanel.add(Pirates_of_the_Caribbean);

		Pixar.setForeground(new java.awt.Color(255, 255, 255));
		Pixar.setText("Pixar");
		Pixar.setName("Pixar");
		Pixar.addItemListener(this);
		CatPanel.add(Pixar);

		Pocahontas.setForeground(new java.awt.Color(255, 255, 255));
		Pocahontas.setText("Pocahontas");
		Pocahontas.setName("Pocahontas");
		Pocahontas.addItemListener(this);
		CatPanel.add(Pocahontas);

		Prince.setForeground(new java.awt.Color(255, 255, 255));
		Prince.setText("Prince");
		Prince.setName("Prince");
		Prince.addItemListener(this);
		CatPanel.add(Prince);

		Princess_and_the_Frog.setForeground(new java.awt.Color(255, 255, 255));
		Princess_and_the_Frog.setText("Princess and the Frog");
		Princess_and_the_Frog.setName("Princess_and_the_Frog");
		Princess_and_the_Frog.addItemListener(this);
		CatPanel.add(Princess_and_the_Frog);

		Princesses.setForeground(new java.awt.Color(255, 255, 255));
		Princesses.setText("Princesses");
		Princesses.setName("Princesses");
		Princesses.addItemListener(this);
		CatPanel.add(Princesses);

		Purple.setForeground(new java.awt.Color(255, 255, 255));
		Purple.setText("Purple");
		Purple.setName("Purple");
		Purple.addItemListener(this);
		CatPanel.add(Purple);

		Red.setForeground(new java.awt.Color(255, 255, 255));
		Red.setText("Red");
		Red.setName("Red");
		Red.addItemListener(this);
		CatPanel.add(Red);

		Rescue_Rangers.setForeground(new java.awt.Color(255, 255, 255));
		Rescue_Rangers.setText("Rescue Rangers");
		Rescue_Rangers.setName("Rescue_Rangers");
		Rescue_Rangers.addItemListener(this);
		CatPanel.add(Rescue_Rangers);
		
		Robin_Hood.setForeground(new java.awt.Color(255, 255, 255));
		Robin_Hood.setText("Robin Hood");
		Robin_Hood.setName("Robin_Hood");
		Robin_Hood.addItemListener(this);
		CatPanel.add(Robin_Hood);

		Scary.setForeground(new java.awt.Color(255, 255, 255));
		Scary.setText("Scary");
		Scary.setName("Scary");
		Scary.addItemListener(this);
		CatPanel.add(Scary);

		Sleeping_Beauty.setForeground(new java.awt.Color(255, 255, 255));
		Sleeping_Beauty.setText("Sleeping Beauty");
		Sleeping_Beauty.setName("Sleeping_Beauty");
		Sleeping_Beauty.addItemListener(this);
		CatPanel.add(Sleeping_Beauty);

		Snow_White.setForeground(new java.awt.Color(255, 255, 255));
		Snow_White.setText("Snow White");
		Snow_White.setName("Snow_White");
		Snow_White.addItemListener(this);
		CatPanel.add(Snow_White);

		Star_Wars.setForeground(new java.awt.Color(255, 255, 255));
		Star_Wars.setText("Star Wars");
		Star_Wars.setName("Star_Wars");
		Star_Wars.addItemListener(this);
		CatPanel.add(Star_Wars);

		Tangled.setForeground(new java.awt.Color(255, 255, 255));
		Tangled.setText("Tangled");
		Tangled.setName("Tangled");
		Tangled.addItemListener(this);
		CatPanel.add(Tangled);
		
		The_Emperors_New_Groove.setForeground(new java.awt.Color(255, 255, 255));
		The_Emperors_New_Groove.setText("The Emperor's New Groove");
		The_Emperors_New_Groove.setName("The_Emperors_New_Groove");
		The_Emperors_New_Groove.addItemListener(this);
		CatPanel.add(The_Emperors_New_Groove);

		The_Incredibles.setForeground(new java.awt.Color(255, 255, 255));
		The_Incredibles.setText("The Incredibles");
		The_Incredibles.setName("The_Incredibles");
		The_Incredibles.addItemListener(this);
		CatPanel.add(The_Incredibles);

		The_Jungle_Book.setForeground(new java.awt.Color(255, 255, 255));
		The_Jungle_Book.setText("The Jungle Book");
		The_Jungle_Book.setName("The_Jungle_Book");
		The_Jungle_Book.addItemListener(this);
		CatPanel.add(The_Jungle_Book);

		The_Lion_King.setForeground(new java.awt.Color(255, 255, 255));
		The_Lion_King.setText("The Lion King");
		The_Lion_King.setName("The_Lion_King");
		The_Lion_King.addItemListener(this);
		CatPanel.add(The_Lion_King);

		The_Little_Mermaid.setForeground(new java.awt.Color(255, 255, 255));
		The_Little_Mermaid.setText("The Little Mermaid");
		The_Little_Mermaid.setName("The_Little_Mermaid");
		The_Little_Mermaid.addItemListener(this);
		CatPanel.add(The_Little_Mermaid);

		The_Muppets.setForeground(new java.awt.Color(255, 255, 255));
		The_Muppets.setText("The Muppets");
		The_Muppets.setName("The_Muppets");
		The_Muppets.addItemListener(this);
		CatPanel.add(The_Muppets);

		Toy_Story.setForeground(new java.awt.Color(255, 255, 255));
		Toy_Story.setText("Toy Story");
		Toy_Story.setName("Toy_Story");
		Toy_Story.addItemListener(this);
		CatPanel.add(Toy_Story);

		Underwater.setForeground(new java.awt.Color(255, 255, 255));
		Underwater.setText("Underwater");
		Underwater.setName("Underwater");
		Underwater.addItemListener(this);
		CatPanel.add(Underwater);

		Up.setForeground(new java.awt.Color(255, 255, 255));
		Up.setText("Up");
		Up.setName("Up");
		Up.addItemListener(this);
		CatPanel.add(Up);

		Winnie_the_Pooh.setForeground(new java.awt.Color(255, 255, 255));
		Winnie_the_Pooh.setText("Winnie the Pooh");
		Winnie_the_Pooh.setName("Winnie_the_Pooh");
		Winnie_the_Pooh.addItemListener(this);
		CatPanel.add(Winnie_the_Pooh);

		WreckIt_Ralph.setForeground(new java.awt.Color(255, 255, 255));
		WreckIt_Ralph.setText("Wreck-It Ralph");
		WreckIt_Ralph.setName("WreckIt_Ralph");
		WreckIt_Ralph.addItemListener(this);
		CatPanel.add(WreckIt_Ralph);

		Yellow.setForeground(new java.awt.Color(255, 255, 255));
		Yellow.setText("Yellow");
		Yellow.setName("Yellow");
		Yellow.addItemListener(this);
		CatPanel.add(Yellow);

		Zootopia.setForeground(new java.awt.Color(255, 255, 255));
		Zootopia.setText("Zootopia");
		Zootopia.setName("Zootopia");
		Zootopia.addItemListener(this);
		CatPanel.add(Zootopia);

		BoxLabel.setForeground(new java.awt.Color(211, 211, 211));
		BoxLabel.setText("Boxes");
		BoxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		ExecuteButton.setText("Execute");
		ExecuteButton.setEnabled(false);
		ExecuteButton.addActionListener(this);

		Silver.setForeground(new java.awt.Color(191, 193, 195));
		Silver.setText("Silver");
		Silver.setName("Silver");
		Silver.addActionListener(this);
		BoxPanel.add(Silver);

		Gold.setForeground(new java.awt.Color(240, 189, 92));
		Gold.setText("Gold");
		Gold.setName("Gold");
		Gold.addActionListener(this);
		BoxPanel.add(Gold);

		Rainbow.setForeground(new java.awt.Color(102, 178, 112));
		Rainbow.setText("Rainbow");
		Rainbow.setName("Rainbow");
		Rainbow.addActionListener(this);
		BoxPanel.add(Rainbow);

		Series.setForeground(new java.awt.Color(153, 222, 191));
		Series.setText("Series");
		Series.setName("Series");
		Series.addActionListener(this);
		BoxPanel.add(Series);

		Villain.setForeground(new java.awt.Color(250, 230, 250));
		Villain.setText("Villain");
		Villain.setName("Villain");
		Villain.addActionListener(this);
		BoxPanel.add(Villain);

		None.setForeground(new java.awt.Color(255, 255, 255));
		None.setText("None");
		None.setName("None");
		None.addActionListener(this);
		BoxPanel.add(None);

		Information.setForeground(new java.awt.Color(250, 128, 114));
		Information.setText("Requirements: Up to 3 Groups or 1 Box + Up to 2 Groups");
		Information.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(CatScroll, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(GroupLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(BoxLabel, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(BoxPanel, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
						.addComponent(Information, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(ExecuteButton, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(6, 6, 6)

						.addComponent(GroupLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(CatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 193,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30).addComponent(BoxLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(BoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(Information).addGap(18, 18, 18).addComponent(ExecuteButton)
						.addGap(0, 19, Short.MAX_VALUE)));

		pack();
	}

	public void itemStateChanged(ItemEvent e) {
		JCheckBox check = (JCheckBox) e.getSource();
		if (check.isSelected())
			categories.add(check.getName());
		else
			categories.remove(check.getName());
		buttonStatus();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JRadioButton) {
			JRadioButton rbName = (JRadioButton) e.getSource();
			boxToSearch = rbName.getName();
			buttonStatus();
		} else {
			ArrayList<String> finalCats = new ArrayList<String>(categories);
			if (!boxToSearch.equals("None"))
				finalCats.add(boxToSearch);
			Results rs = new Results();
			rs.setUp(finalCats);
		}
	}

	private void buttonStatus() {
		if (boxToSearch.equals("None")) {
			if (categories.size() > 3 || categories.isEmpty())
				ExecuteButton.setEnabled(false);
			else
				ExecuteButton.setEnabled(true);
		} else {
			if (categories.size() > 2)
				ExecuteButton.setEnabled(false);
			else
				ExecuteButton.setEnabled(true);

		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */

		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DEBCatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}


		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new DEBCatFrame().setVisible(true);
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JCheckBox Aladdin;
	private javax.swing.JCheckBox Alice_in_Wonderland;
	private javax.swing.JCheckBox Animal;
	private javax.swing.JCheckBox Bearded;
	private javax.swing.JCheckBox Beauty_and_the_Beast;
	private javax.swing.JCheckBox BigEared;
	private javax.swing.JCheckBox Blue;
	private javax.swing.JLabel BoxLabel;
	private javax.swing.JPanel BoxPanel;
	private javax.swing.JCheckBox Boys;
	private javax.swing.JPanel CatPanel;
	private javax.swing.JCheckBox Cat_or_Dog;
	private javax.swing.JCheckBox Coco;
	private javax.swing.JButton ExecuteButton;
	private javax.swing.JCheckBox Fairies;
	private javax.swing.JCheckBox Finding_NemoDory;
	private javax.swing.JCheckBox Flying;
	private javax.swing.JCheckBox FourLegged;
	private javax.swing.JCheckBox Frozen;
	private javax.swing.JCheckBox Girls;
	private javax.swing.JRadioButton Gold;
	private javax.swing.JCheckBox Green;
	private javax.swing.JLabel GroupLabel;
	private javax.swing.JCheckBox Hatwearing;
	private javax.swing.JCheckBox Haunted_Mansion;
	private javax.swing.JCheckBox Hercules;
	private javax.swing.JLabel Information;
	private javax.swing.JCheckBox Inside_Out;
	private javax.swing.JCheckBox Jewelry;
	private javax.swing.JCheckBox Mickey_and_Friends;
	private javax.swing.JCheckBox Moana;
	private javax.swing.JCheckBox Monsters_Inc;
	private javax.swing.JCheckBox Mulan;
	private javax.swing.JCheckBox Nightmare_Before_Christmas;
	private javax.swing.JRadioButton None;
	private javax.swing.JCheckBox Orange;
	private javax.swing.JCheckBox Outer_Space;
	private javax.swing.JCheckBox Pirates_of_the_Caribbean;
	private javax.swing.JCheckBox Pixar;
	private javax.swing.JCheckBox Pocahontas;
	private javax.swing.JCheckBox Prince;
	private javax.swing.JCheckBox Princess_and_the_Frog;
	private javax.swing.JCheckBox Princesses;
	private javax.swing.JCheckBox Purple;
	private javax.swing.JRadioButton Rainbow;
	private javax.swing.JCheckBox Red;
	private javax.swing.JCheckBox Rescue_Rangers;
	private javax.swing.JCheckBox Robin_Hood;
	private javax.swing.JCheckBox Scary;
	private javax.swing.JRadioButton Series;
	private javax.swing.JRadioButton Silver;
	private javax.swing.JCheckBox Sleeping_Beauty;
	private javax.swing.JCheckBox Snow_White;
	private javax.swing.JCheckBox Star_Wars;
	private javax.swing.JCheckBox Tangled;
	private javax.swing.JCheckBox The_Emperors_New_Groove;
	private javax.swing.JCheckBox The_Incredibles;
	private javax.swing.JCheckBox The_Jungle_Book;
	private javax.swing.JCheckBox The_Lion_King;
	private javax.swing.JCheckBox The_Little_Mermaid;
	private javax.swing.JCheckBox The_Muppets;
	private javax.swing.JCheckBox Toy_Story;
	private javax.swing.JCheckBox Underwater;
	private javax.swing.JCheckBox Up;
	private javax.swing.JRadioButton Villain;
	private javax.swing.JCheckBox Winnie_the_Pooh;
	private javax.swing.JCheckBox WreckIt_Ralph;
	private javax.swing.JCheckBox Yellow;
	private javax.swing.JCheckBox Zootopia;
	private javax.swing.ButtonGroup buttonGroup;
	ArrayList<String> categories;
	ArrayList<String> boxes;
	String boxToSearch = "None";
	// End of variables declaration

}
