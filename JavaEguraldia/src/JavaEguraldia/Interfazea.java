/*
 * 20 mar 2024
 * Ioritz Lopetegi
 */
package JavaEguraldia;

import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;

import JavaEguraldia.Eguraldia;
import JavaEguraldia.Eguraldia.Clouds;
import JavaEguraldia.Eguraldia.Main2;

// TODO: Auto-generated Javadoc
/**
 * 
 * @author Ioritz Lopetegi
 */
public class Interfazea extends JFrame {

	/** Interfazearen izena. */
	private String InterfIzena;
	
	/** Interfazearen titulua. */
	private String InterfTitulua;
	
	/** Interfazearen  altuera. */
	private Integer InterfAltuera;
	
	/** Interfazearen zabalera. */
	private Integer InterfZabalera;
	
	/** Interfazearen Layout-a. */
	private LayoutManager Interflayout;
	
	/** Interfazea ikusgarri / ez ikusgarri. */
	private boolean InterfIkusi;

	/** Gure interfazearen konponenteak gordetzeko arraylist-a. */
	private ArrayList Konponenteak;
	
	/** Interfazearen posizioa X. */
	private Integer InterfPosX;
	
	/** Interfazearen posizioa Y. */
	private Integer InterfPosY;

	Eguraldia javaEguraldia = new Eguraldia();
	String cityName = "Tolosa,ES";  
	
	Eguraldia eguraldia = new Eguraldia();
	
	String tenperaturaString;
	
	String tenperaturamaxString;
	String	tenperaturaminString;
	String baldintzameteoString;
	String HaizeaNorantzaString;
	String HaizeaAbiaduraString;
	Double EuriKantitateaDouble;
	Double elurKantitateaDouble;
	Double lainoportzentaia;
	Long sunrisetimestamp;
	Long sunsetsetimestamp;
	int sunsettimezone;
	int sunrisetimezone;

	
	/**
	 * Interfaze berria sortu eta hasieratzen du.
	 *
	 * @param izenaString , Interfazaren izena
	 * @param tituluaString, interfazearen titulua
	 * @param altuera, interfazearen altuera
	 * @param zabalera, interfazearen zabalera
	 * @param ikusgarri, interfazearen ikusgarritasuna
	 * @see Interfazea#initUI()
	 */
	public Interfazea(String izenaString, String tituluaString, int altuera, int zabalera, boolean ikusgarri) {

		this.InterfIzena = izenaString;
		this.InterfTitulua = tituluaString;
		this.InterfAltuera = altuera;
		this.InterfZabalera = zabalera;
		this.InterfIkusi = ikusgarri;
		this.Konponenteak = new ArrayList<>();
		

		this.initUI();

	}
	
	/**
	 * 
	 */
	public Interfazea() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Interfazearen titulua
	 */
	public String getInterfTitulua() {
		return InterfTitulua;
	}

	/**
	 * @return Interfazearen layout-a
	 */
	public LayoutManager getInterflayout() {
		return Interflayout;
	}

	/**
	 * @return Interfazea ikusgarri edo ez
	 */
	public boolean getisInterfIkusi() {
		return InterfIkusi;
	}
	
	/**
	 * Konponenteak eskuratzen ditu
	 *
	 * @return Jframe konponenteak
	 */
	public ArrayList<JComponent> getKonponenteak() {
		  
		  return new ArrayList<>(Konponenteak);
		}
	
	/**
	 * Jframe konponenteak garbitu.
	 */
	public void konponenteakgarbitu () {
		Konponenteak.clear();
	}
	
	/**
	 * Window Listener-a gehitzen du.
	 *
	 * @param listener,xagu gertaera
	 */
	public void addWindowListener(WindowListener listener) {
		  super.addWindowListener(listener);
		}
	
	/**
	 * Key listener-a gehitu.
	 *
	 * @param listener, teklatu gertaera
	 */
	public void addKeyListener(KeyListener listener) {
		  super.addKeyListener(listener);
		}

	/**Interfazearen titulua ezarri
	 * 
	 * @param Interfazearen titulua
	 */
	public void setInterfTitulua(String interfTitulua) {
		InterfTitulua = interfTitulua;
	}

	/**Interfazearen layout-a ezarri
	 * 
	 * @param Interfazearen layout mota
	 */
	public void setInterflayout(LayoutManager interflayout) {
		Interflayout = interflayout;
	}

	/** ikusgarritasuna ezarri inerfazearentzat
	 * 
	 * @param interfIkusi  
	 */
	public void setInterfIkusi(boolean interfIkusi) {
		InterfIkusi = interfIkusi;
	}

	
	/**
	 * Interfaze tamaina ezartzen du
	 *
	 * @param altuera, interfazearen altuera zehatza, zenbaki osoa
	 * @param zabalera, interfazearen zabalera zehatza,zenbaki osoa
	 */
	public void setInterfTamaina( int altuera, int zabalera) {
		
		InterfAltuera = altuera;
		InterfZabalera = zabalera;
		
	}
	
	/**
	 * Interfazearen posizioa itzultzen du.
	 *
	 * @param x 
	 * @param y 
	 */
	public void SetInterfPosizioa ( int x , int y) {
		
		InterfPosX = x;
		InterfPosY = y;
			
	}
	
	/**
	 * Interfazea hasieratzen du.
	 */
	private void initUI() {
	   setName(InterfIzena);
	    setTitle(InterfTitulua);
	    setSize(InterfZabalera, InterfAltuera);
	    setVisible(InterfIkusi);
	    setLayout(new BorderLayout());
	}
	
	/**
	 * Konponentea gehitzen du
	 *
	 * @param konponentea, JFrame-eko konponenteak
	 */
	public void addkonponentea(JComponent konponentJComponent) {
		  Konponenteak.add(konponentJComponent);
		// JFrameren maketazioari ere osagaia gehitu nahiko bageenioke hemen : konponenteak.add(component,borderlayout.center)
		}
	
	
	/**
	 * Konponentea ezabatzen du.
	 *
	 * @param konponentea, JFrame-eko konponenteak
	 */
	public void removekonponentea(JComponent konponentJComponent) {
		  Konponenteak.remove(konponentJComponent);
	
		}
	
	/**
	 * Content pane-a eskuratzen du.
	 *
	 * @return gure containerra
	 */
	public Container getContentPane() {
		  return super.getContentPane();
		}
	
	/**
	 * Interfazeari pack egiten dio.
	 */
	public void pack() {
		  super.pack();
		}
	public void HomeMenuSortu() {
        Interfazea homeMenuInterfazea = new Interfazea("JavaEguraldia", "JavaEguraldia", 600, 1000, true);
        
        BorderLayout homemenuBorderLayout = new BorderLayout();
        
        homeMenuInterfazea.setLocationRelativeTo(null);
        homeMenuInterfazea.setInterflayout(homemenuBorderLayout);
        homeMenuInterfazea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Goiko panela 
        JPanel GoikoPanela = new JPanel();
        GoikoPanela.setLayout(new GridLayout(1, 2,0,0)); // Gap between columns (5px), no gap between rows (0px)

        //GoikoPanela.setBackground(Color.blue);

        // Konponenteak gehitu goiko panelean
        
        
        
        
   
        JLabel hiriaJLabel = new JLabel("Hiria:");
        GoikoPanela.add(hiriaJLabel);

        JTextField ubikazioaTextField = new JTextField(20);
        GoikoPanela.add(ubikazioaTextField);
        
        String hiria = null;
	      try {
	        Eguraldia eguraldia = new Eguraldia();
	        hiria = eguraldia.getHiriaIzenaHome();
	      } catch (IOException ex) {
	        System.err.println("Error fetching city name: " + ex.getMessage());
	      }

	      if (hiria != null) {
	        // Update UI with the retrieved city name (e.g., display in a label)
	        hiriaJLabel.setText("Hiria : " + hiria);
	      } else {
	        System.err.println("Error al obtener la ciudad");
	      }
	      
	      
	      JLabel tenperaturaLabel = new JLabel("Tenperatura: ");
	      JLabel tenperaturamaxLabel = new JLabel("Tenperatura Max: ");
	      JLabel tenperaturaminLabel = new JLabel("Tenperatura Min: ");
	      JLabel BaldintzaMeteorologikoakLabel = new JLabel("Baldintza Meteorologikoak: ");
	      
	      JLabel BaldintzaMeteorologikoakTextField = new JLabel();
	        JLabel EuriKantitateaJLabel = new JLabel("");
	        JLabel ElurKantitateaJLabel = new JLabel("");
	        JLabel LainoPortzentaiaJLabel = new JLabel("");
	        JLabel sunriseLabel = new JLabel("Sunrise: ");
	        JLabel sunsetlabel = new JLabel("Sunset: ");
	      
	        JLabel haizeaNorantzaJLabel = new JLabel("Haizearen norantza: ");
	        JLabel haizeaAbiadruaJLabel = new JLabel("Haizearen abiadura: ");
	      

        // Add action listener to update hiriaJLabel text
        ubikazioaTextField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  if (e.getSource() == ubikazioaTextField) {
        	      String hiria = ubikazioaTextField.getText();
        	      try {
        	        
        	        hiria = eguraldia.getHiriaIzena(hiria);
        	        
        	        try {
        	        	Eguraldia eguraldia = new Eguraldia();
        		        tenperaturaString = eguraldia.getTemperatura(hiria);
        		       
        		        	tenperaturaLabel.setText("Tenperatura: "+tenperaturaString + " °C");
        			
        			} catch (Exception a) {
        				// TODO: handle exception
        			}
        	        
        	        try {
        	        	
        		        tenperaturamaxString = eguraldia.getTemperaturamax(hiria);
        		       
        		        tenperaturamaxLabel.setText("Tenperatura Max: "+tenperaturamaxString + " °C");
        			
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        
        	        try {
        	        	Eguraldia eguraldia = new Eguraldia();
        		        tenperaturaminString = eguraldia.getTemperaturamin(hiria);
        		       
        		        tenperaturaminLabel.setText("Tenperatura Min: "+tenperaturaminString + " °C");
        			
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        
        	        
        	        
        	        
        	        try {
        	        	Eguraldia eguraldia = new Eguraldia();
        		        baldintzameteoString = eguraldia.getBaldintzameteorologikoa(hiria);
        		        
        		        if (baldintzameteoString.equalsIgnoreCase("Clouds")) {
        		        	
        		        	BaldintzaMeteorologikoakTextField.setText("Lainoak");
        					
        				}
        		        else if (baldintzameteoString.equalsIgnoreCase("Rain")) {
        		        	
        		        	BaldintzaMeteorologikoakTextField.setText("Euria");
        		        	try {
        		        		
        		              	EuriKantitateaDouble = eguraldia.geteurikantitatea(hiria);
        		              	EuriKantitateaJLabel.setText("Euri Kantitatea: "+EuriKantitateaDouble);
        		        	        
        		        		} catch (Exception e1) {
        		        			// TODO: handle exception
        		        		}

        		        	
        					
        				}
        		        else if (baldintzameteoString.equalsIgnoreCase("Snow")) {
        		        	BaldintzaMeteorologikoakTextField.setText("Elurra");
        	 	try {
        		        		
        		              	elurKantitateaDouble = eguraldia.getElurkantitatea(hiria);
        		              	ElurKantitateaJLabel.setText("Elur Kantitatea: "+elurKantitateaDouble);
        		        	        
        		        		} catch (Exception e1) {
        		        			// TODO: handle exception
        		        		}
        					
        				}
        		        else if (baldintzameteoString.equalsIgnoreCase("Clear")) {
        		        	BaldintzaMeteorologikoakTextField.setText("Eguzkia");
        					
        				}
        		        
        		        
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        
        	        try {
        	        	Eguraldia eguraldia = new Eguraldia();
        	        	lainoportzentaia = eguraldia.getlainoportzentaia(hiria);
        	        	LainoPortzentaiaJLabel.setText("Laino Portzentaia: "+lainoportzentaia +"%");
        		        
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        
        	        try {
        	        	
        		        sunrisetimestamp = eguraldia.getsunrise(hiria);
        		        sunrisetimezone = eguraldia.gettimezone(hiria);
        		        String datasunrise = eguraldia.getFecha(sunrisetimestamp, sunrisetimezone);
        		        System.out.println("Data: " + datasunrise);
        		        sunriseLabel.setText("sunrise: "+datasunrise);
        			
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        
        	        try {
        	        	Eguraldia eguraldia = new Eguraldia();
        		        sunsetsetimestamp = eguraldia.getsunset(hiria);
        		        sunsettimezone = eguraldia.gettimezone(hiria);
        		        String datasunset = eguraldia.getFecha(sunsetsetimestamp, sunsettimezone);
        		        System.out.println("Data: " + datasunset);
        		       
        		        sunsetlabel.setText("SunSet: "+datasunset);
        			
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        
        	        try {
        	        	Eguraldia eguraldia = new Eguraldia();
        	        	HaizeaNorantzaString = eguraldia.getHaizearenNorantza(hiria);
        	        	haizeaNorantzaJLabel.setText("Haizearen norantza: "+HaizeaNorantzaString);
        		        
        			} catch (Exception e1) {
        				// TODO: handle exception
        			}
        	        
        	        try {
        	           	Eguraldia eguraldia = new Eguraldia();
        	           	HaizeaAbiaduraString = eguraldia.getHaizearenAbiadura(hiria);
        	           	haizeaAbiadruaJLabel.setText("Haizearen abiadura: "+HaizeaAbiaduraString);
        	    	        
        	    		} catch (Exception e1) {
        	    			// TODO: handle exception
        	    		}
        	        
        	        
        	        
        	        
        	        
        	        //Metodoak hemen ezarri bilatu ondoren egiteko
        	        
        	      } catch (IOException ex) {
        	        System.err.println("Error fetching city name: " + ex.getMessage());
        	      }
        	      
        	      
        	  

        	      if (hiria != null) {
        	        // Update UI with the retrieved city name (e.g., display in a label)
        	    	  hiriaJLabel.setText("Hiria : " + hiria);
        	      } else {
        	        System.err.println("Error al obtener la ciudad");
        	      }
        	    }
        	  }
          
        });
        
        

        JLabel DataorduLabel = new JLabel("Eguna eta ordua: ");
        GoikoPanela.add(DataorduLabel);

        JLabel DataorduTextField = new JLabel();
        DataorduTextField.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        GoikoPanela.add(DataorduTextField);
       
       
  
        
        
        
        
        JPanel ErdikoPanela = new JPanel();
        ErdikoPanela.setLayout(new GridLayout(1, 2));

        //Erdiko Paneleko konponenteak gehitu
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        
        JPanel TenperaturaPanel = new JPanel();
        
        leftPanel.add(TenperaturaPanel);
        TenperaturaPanel.setLayout(new BoxLayout(TenperaturaPanel, BoxLayout.Y_AXIS));
        
        
       

    
        

        JLabel tenperaturaTextField = new JLabel();
        
        try {
        	Eguraldia eguraldia = new Eguraldia();
	        tenperaturaString = eguraldia.getTemperaturaHome();
	       
	        	tenperaturaLabel.setText("Tenperatura: "+tenperaturaString + " °C");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
        
       

     
        
        try {
        	Eguraldia eguraldia = new Eguraldia();
	        tenperaturamaxString = eguraldia.getTemperaturamaxHome();
	       
	        tenperaturamaxLabel.setText("Tenperatura Max: "+tenperaturamaxString + " °C");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
        
       
        

        try {
        	Eguraldia eguraldia = new Eguraldia();
	        tenperaturaminString = eguraldia.getTemperaturaminHome();
	       
	        tenperaturaminLabel.setText("Tenperatura Min: "+tenperaturaminString + " °C");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
        
     
        
        
        
        leftPanel.add(tenperaturaLabel);
        leftPanel.add(tenperaturaTextField);
        leftPanel.add(tenperaturamaxLabel);
        leftPanel.add(tenperaturaminLabel);

        
        JPanel RightPanel = new JPanel();

        
        TenperaturaPanel.add(tenperaturaLabel);
        TenperaturaPanel.add(tenperaturamaxLabel);
        
     
        
     

        
        RightPanel.add(BaldintzaMeteorologikoakLabel);

       
        
        try {
        	Eguraldia eguraldia = new Eguraldia();
	        baldintzameteoString = eguraldia.getBaldintzameteorologikoaHome();
	        
	        if (baldintzameteoString.equalsIgnoreCase("Clouds")) {
	        	
	        	BaldintzaMeteorologikoakTextField.setText("Lainoak");
				
			}
	        else if (baldintzameteoString.equalsIgnoreCase("Rain")) {
	        	
	        	BaldintzaMeteorologikoakTextField.setText("Euria");
	        	try {
	        		
	              	EuriKantitateaDouble = eguraldia.geteurikantitateaHome();
	              	EuriKantitateaJLabel.setText("Euri Kantitatea: "+EuriKantitateaDouble);
	        	        
	        		} catch (Exception e) {
	        			// TODO: handle exception
	        		}

	        	
				
			}
	        else if (baldintzameteoString.equalsIgnoreCase("Snow")) {
	        	BaldintzaMeteorologikoakTextField.setText("Elurra");
 	try {
	        		
	              	elurKantitateaDouble = eguraldia.getElurkantitateaHome();
	              	ElurKantitateaJLabel.setText("Elur Kantitatea: "+elurKantitateaDouble);
	        	        
	        		} catch (Exception e) {
	        			// TODO: handle exception
	        		}
				
			}
	        else if (baldintzameteoString.equalsIgnoreCase("Clear")) {
	        	BaldintzaMeteorologikoakTextField.setText("Eguzkia");
				
			}
	        
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        
        
       
        RightPanel.add(BaldintzaMeteorologikoakTextField);
        try {
        	Eguraldia eguraldia = new Eguraldia();
        	lainoportzentaia = eguraldia.getlainoportzentaiaHome();
        	LainoPortzentaiaJLabel.setText("Laino Portzentaia: "+lainoportzentaia +"%");
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        RightPanel.add(LainoPortzentaiaJLabel);
        
        try {
        	Eguraldia eguraldia = new Eguraldia();
	        sunrisetimestamp = eguraldia.getsunrisehome();
	        sunrisetimezone = eguraldia.gettimezonehome();
	        String datasunrise = eguraldia.getFecha(sunrisetimestamp, sunrisetimezone);
	        System.out.println("Data: " + datasunrise);
	        sunriseLabel.setText("sunrise: "+datasunrise);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        RightPanel.add(sunriseLabel);
        
        try {
        	Eguraldia eguraldia = new Eguraldia();
	        sunsetsetimestamp = eguraldia.getsunsethome();
	        sunsettimezone = eguraldia.gettimezonehome();
	        String datasunset = eguraldia.getFecha(sunsetsetimestamp, sunsettimezone);
	        System.out.println("Data: " + datasunset);
	       
	        sunsetlabel.setText("SunSet: "+datasunset);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        RightPanel.add(sunsetlabel);
        
       
      
        
        try {
        	Eguraldia eguraldia = new Eguraldia();
        	HaizeaNorantzaString = eguraldia.getHaizearenNorantzaHome();
        	haizeaNorantzaJLabel.setText("Haizearen norantza: "+HaizeaNorantzaString);
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
  
       RightPanel.add(haizeaNorantzaJLabel);
       
      
       
       
       try {
       	Eguraldia eguraldia = new Eguraldia();
       	HaizeaAbiaduraString = eguraldia.getHaizearenAbiaduraHome();
       	haizeaAbiadruaJLabel.setText("Haizearen abiadura: "+HaizeaAbiaduraString);
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
 
      RightPanel.add(haizeaAbiadruaJLabel);
      
      
      
      
      
     RightPanel.add(EuriKantitateaJLabel);
      
      
       
        

//        ImageIcon KlimaIrudia = new ImageIcon("C:\\Users\\1ag3.iorilope\\Downloads\\weather-forecast.png"); // Your image path
//        JLabel KlimaIrudiaLabel = new JLabel(KlimaIrudia);
//        RightPanel.add(KlimaIrudiaLabel);

        ErdikoPanela.add(leftPanel);
        ErdikoPanela.add(RightPanel);
        
     
        
//        JPanel panelInferior = new JPanel();
//        panelInferior.setLayout(new FlowLayout());
//
//        // Añadir componentes al panel inferior
//        JLabel pronosticoLabel = new JLabel("Pronóstico: ");
//        panelInferior.add(pronosticoLabel);
//
//        JComboBox pronosticoComboBox = new JComboBox();
//        pronosticoComboBox.addItem("Hoy");
//        pronosticoComboBox.addItem("Mañana");
//        pronosticoComboBox.addItem("Próximos 7 días");
//        panelInferior.add(pronosticoComboBox);

        
        
        homeMenuInterfazea.add(GoikoPanela, BorderLayout.NORTH);
        homeMenuInterfazea.add(ErdikoPanela, BorderLayout.CENTER);
       // homeMenuInterfazea.add(panelInferior, BorderLayout.SOUTH);
        
        
        
        homeMenuInterfazea.pack();
        
    }
	
	
	

	   

	    private static JPanel crearPanelInferior() {
	        JPanel panelInferior = new JPanel();
	        panelInferior.setLayout(new FlowLayout());

	        // Añadir componentes al panel inferior
	        JLabel pronosticoLabel = new JLabel("Pronóstico: ");
	        panelInferior.add(pronosticoLabel);

	        JComboBox pronosticoComboBox = new JComboBox();
	        pronosticoComboBox.addItem("Hoy");
	        pronosticoComboBox.addItem("Mañana");
	        pronosticoComboBox.addItem("Próximos 7 días");
	        panelInferior.add(pronosticoComboBox);

	        return panelInferior;
	    }
	}
	
	
	
	

