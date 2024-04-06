package menu;

import basic.INFO;
import basic.Root;
import fonts.FM;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.Show;

public class Menu{
	public static Scene menu;
	public static void initScene() {
		ImageView logo = new ImageView(new Image(INFO.sp+"qulogo.png"));
		logo.setFitWidth(250);
		logo.setFitHeight(150);
		
		ImageView start = new ImageView(new Image(INFO.sp+"start.png"));
		int stW= 250;
		int stH= 100;
		start.setFitWidth(stW);
		start.setFitHeight(stH);
		start.setY(175);
		start.setX(100);
		start.setOnMouseClicked(event -> {
            switchView();
        });
		
		HBox hbox =new HBox();
		hbox.getChildren().add(logo);
		
		Group root = new Group();
		root.getChildren().addAll(hbox,start);
		
        start.setOnMouseEntered(e -> {
            // �Ŵ󶯻�
        	start.setScaleX(1.2);
        	start.setScaleY(1.2);
        });
 
        start.setOnMouseExited(e -> {
            // ��С��ԭʼ��С
        	start.setScaleX(1);
        	start.setScaleY(1);
        });
		
        ImageView about = new ImageView(new Image(INFO.sp+"about.png"));
        about.setFitWidth(150);
        about.setFitHeight(150);
        about.setY(720-250);
        about.setX(100);
		
		root.getChildren().add(about);
		
        about.setOnMouseEntered(e -> {
            // �Ŵ󶯻�
        	about.setScaleX(1.2);
        	about.setScaleY(1.2);
        });
 
        about.setOnMouseExited(e -> {
            // ��С��ԭʼ��С
        	about.setScaleX(1);
        	about.setScaleY(1);
        });
        
        about.setOnMouseClicked(event -> {
            clickAbout();
        });
        
        Image image = new Image(INFO.sp+"lines2.png"); // �滻Ϊ���ͼƬ·��
        ImageView imageView = new ImageView(image);
        imageView.setX(1280-720);
        root.getChildren().add(imageView);
        
		menu=new Scene(root);
		menu.setFill(Color.BLACK);
	}
	
	public static void switchView() {
		Show.sm();
	}

	public static void clickAbout() {
		/*HBox root=new HBox();
		Stage about=new Stage();
		Scene s=new Scene(root,INFO.w,INFO.h,Color.WHITE);
		about.setTitle(INFO.gamename+" ����");
		Label title=new Label("����");
		title.setFont(FM.normal);
		
		root.getChildren().addAll(title);
		about.setScene(s);
		about.initOwner(Root.stage);
		//Root.stage.show();
		about.show();*/
		
		//Stage s1 = new Stage();
        //s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle(INFO.gamename+" ����");
        VBox root=new VBox();
        Label title=new Label("���� �� ��Ȩ��Ϣ\n");
        title.setTextFill(Color.WHITE);
        title.setFont(FM.normalTitle);
        Text text=new Text();
        text.setText("Copyright (c) SweetPeach.��Ȩ����.\n"+
        			 "logo��ơ���ͼ ��XiaoYv��upbingun����һ�����ո���.\n"+
        			 "�����ߣ�XiaoYv��upbingun.\n"+
        			 "ԭ����TubroWarp����Linegros (by XiaoYv).\n"+
        			 "�ͷ���txy1145141919@outlook.com  .\n"+
        			 "bug������upbingun@163.com   .\n"+
        			 "���棺JavaFX8 (Oracle OpenJDK8).\n"+
        			 "���壺OPlusSans 3.0&Streaming Neon��������/fonts��.\n"+
        			 "������OPPO��˾��û��OPlusSans����Ϣ�����Ը�������ʱ���ܸ�������\n"+
        			 "���У�\n"+
        			 "XiaoYv�ṩ��Logo��ƣ�upbingunͬ���ṩ��ʹ�õ�����XiaoYv��Ƶ�.\n"+
        			 "Liner����������Ҫ��XiaoYv���.\n"+
        			 "���������ǵ��Ͷ��ɹ�����ʹ���ǿ�Դ��.\n"+
        			 "��ĿGithub��ַ��https://github.com/upbingun233/Linegros\n"+
        			 "��л���ǵĹ��ף�\n\n"+
        			 "����.");
        text.setFont(FM.normal);
        text.setFill(Color.WHITE);
        root.setStyle("-fx-background-color:black");
        root.getChildren().addAll(title,text);
        Scene s=new Scene(root,INFO.w,INFO.h);
        // s1��s2;
        s2.initOwner(Root.stage);
        s2.setScene(s);
        s2.show();
	}
}

