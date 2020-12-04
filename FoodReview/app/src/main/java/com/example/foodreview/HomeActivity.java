package com.example.foodreview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView relist;
    ArrayList<Food> fd;
    FoodHelperDb Mydb;
    CustomAdapter customAdapter;
    GridLayoutManager gridLayoutManager;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotonextactivity = new Intent(HomeActivity.this,UserAdding_item.class);
                startActivity(gotonextactivity);
            }
        });

        fd =new ArrayList<>();
        Mydb = new FoodHelperDb(HomeActivity.this);

        if(Mydb.cur().getCount()==0){
            addtodbfood();
        }


        relist =(RecyclerView)findViewById(R.id.recyclerview);
        CustomAdapter customAdapter = new CustomAdapter(HomeActivity.this,fd);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        relist.setLayoutManager(gridLayoutManager);
        relist.setAdapter(customAdapter);
    }
    public void addtodbfood(){
        Mydb.addingitem("Kannur","Thalassery Chicken biriyani","https://www.yummyoyummy.com/wp-content/uploads/2015/04/Thalasseri-chicken-biriyani1_thumb3.jpg",4.5,"Made with spicy chicken and meal rice","https://www.thetakeiteasychef.com/thalassery-chicken-biriyani-recipe");
        Mydb.addingitem("Kozhikode","Kozhikodan Halwa","https://img.onmanorama.com/content/dam/mm/en/food/foodie/images/2020/2/15/halwa.jpg",4.2,"best in taste","https://indiavivid.com/story-kozhikode-halwa-sweet-savor/");
        Mydb.addingitem("Wayanad","Mulayari payasam","https://healthyliving.natureloc.com/wp-content/uploads/2015/09/Bamboo-rice-payasam-Nature-loc-1024x768.jpg",4.5,"Made with light bamboo rice","https://mildlyindian.com/bamboo-rice-payasam-exotic-dessert-kheer/");
        Mydb.addingitem("Alappuzha","karimeen pollichathu","https://www.floohoo.com/wp-content/uploads/2019/02/kerala-style-karimeen-pollichathu.jpg",4.2,"Made with karimeen","https://www.hungryforever.com/recipe/karimeen-pollichathu-recipe/");
        Mydb.addingitem("Kasaragod","Unnakkaya","https://sanaskitchn.files.wordpress.com/2019/02/img_20190223_150440.jpg?w=1376",4.1,"Made with banana","https://www.keralatourism.org/video-gallery/unnakaya-malabar-cuisine/315");
        Mydb.addingitem("Kollam","Vella naranga curry","https://4.bp.blogspot.com/-bx5M_kkLi6I/Wcp6EdehbyI/AAAAAAAANxc/CMb6rN_HhhcYDtMemYCZsEd9h7Pa-J-nwCLcBGAs/s1600/IMG_5821.JPG",4.3,"Made with Naranga","http://www.goodfoodseeker.com/assorted-recipes/vella-naranga-achar-white-lemon-pickle-kerala-style/");
        Mydb.addingitem("Pathanamthitta","Chena Erissery","https://www.cookingandme.com/wp-content/uploads/2011/01/5332074328_3fd96388a4.jpg",4.4,"Made with chena","https://mariasmenu.com/vegetarian/chena-erissery");
        Mydb.addingitem("Wayanad","Nurukku Gothambu payasam","https://img-global.cpcdn.com/recipes/dcabfec26cf25875/751x532cq70/nurukku-gothambu-payasam-broken-wheat-payasam-recipe-main-photo.jpg",4.4,"Made with wheat","https://www.yummyoyummy.com/2012/08/nurukku-gothambu-payasam-broken-wheat.html");
        Mydb.addingitem("Kannur","Thengayaracha meen curry","https://elephantsandthecoconuttrees.com/wp-content/uploads/2012/09/a98ea-img_2370.jpg?w=300",4.7,"Made with fish","https://recipesaresimple.com/recipe/kerala-thenga-aracha-meen-curry/");
        Mydb.addingitem("Kasaragod","Inchi tairu","https://www.kothiyavunu.com/wp-content/uploads/2012/04/Inji-Thayir-Injithairu-Injithair-28129.jpg",4.1,"Made with curd","https://sampoornasasyaaharashala.wordpress.com/2018/03/02/inchi-thairu-ginger-curd-kerala-nadan-curry/");
        Mydb.addingitem("Palakkad","Pazham Nurukku","https://southindianfoods.in/images/pazha-norukku-nenthra-pazham-nurukku.jpg",4.2,"Made with banana","https://pachakam.com/recipes/pazham-nurukku");
        Mydb.addingitem("Kottayam","Ethakka Pulissery","https://swaadofkeralacom.files.wordpress.com/2018/09/sok-2-nendrapazham-pulissery-ethappazham-pulissery-kerala-banana-pulissery.jpg?w=768",4.0,"Made with Ethakka","https://www.kothiyavunu.com/2013/04/ethapazham-pulissery-nenthra-pazham/");
        Mydb.addingitem("Thrissur","Pork Varattiyatu","https://img-global.cpcdn.com/recipes/2efadd89fd129461/751x532cq70/kerala-style-pork-fry-recipe-main-photo.jpg",4.3,"Made with pork","https://cookpad.com/in/recipes/13468649-kerala-pork-roast-thrissur-style");
        Mydb.addingitem("Malappuram","chicken surbiyaan","https://finmail-site-bucket.s3.ap-southeast-1.amazonaws.com/wp-content/uploads/2020/08/23093407/surb.jpg",3.9,"Made with chicken","https://www.mysomalifood.com/somali-style-rice-surbiyaan/");
        Mydb.addingitem("Thiruvananthapuram","Kozhi Porichathu","https://foodiesuzrecipes.com/wp-content/uploads/2019/12/F7AD8C56-7901-4A75-88FB-B2CA53899F15.jpg",3.8,"Made with chicken","https://www.snazzycuisine.com/recipe/kozhi-porichathu-recipe/");
        Mydb.addingitem("Idukki","Kairali Thali","https://www.gozocabs.com/blog/wp-content/uploads/2018/03/Kairali-Thali-768x514.jpg",3.9,"Made with Rice/thali","https://breathtakingindia.com/ReadMore.aspx?Type=Thingstodo&Id=3004f422-a0d2-4d6b-99a0-8cfb0873c198");

        Mydb.addingitem("Common items","Biriyani","https://www.patnadaily.com/images/stories/recipes/cropped-hyderabadi_biryani.jpg",4.2,"Spicy rice with chicken","https://en.wikipedia.org/wiki/Biryani");
        Mydb.addingitem("Common items","Porotta","https://s3-ap-southeast-1.amazonaws.com/sb-singleserver-prod-bucket/2882229e90535c401037d4cfcae0078f/o_1529481460.jpg",4.0,"Made with Maida/wheat","https://en.wikipedia.org/wiki/Parotta");
        Mydb.addingitem("Common items","Chilli Chicken","https://i.livingfoodz.com/blog_images/defc2868e82aaccc219149e6e1b1596b_thumb_1200.jpg",4.5,"Made with Chicken with spice","https://www.indianhealthyrecipes.com/chilli-chicken-dry-recipe-indo-chinese-style/");
        Mydb.addingitem("Common items","Fried Rice","https://www.maggi.in/sites/default/files/2019-10/Veg-FriedRice-1082x461.jpg",4.6,"Made with Rice,Chicken,Egg","https://en.wikipedia.org/wiki/Fried_rice");
        Mydb.addingitem("Common items","Sadhya","https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Sadhya_DSW.jpg/450px-Sadhya_DSW.jpg",4.8,"Rice item with all flavours of curry","https://en.wikipedia.org/wiki/Sadhya");
        Mydb.addingitem("Common items","Kuzhi Mandi","https://media-cdn.tripadvisor.com/media/photo-s/16/97/ab/1f/chicken-mandie.jpg",4.5,"Made with Chicken filled with rice","https://indianonlinespices.com/how-to-make-chicken-kuzhi-mandi%EF%BB%BF/#:~:text=January%2018%2C%202019%20%2F%20by%20Lino,by%20two%20or%20more%20people.");
        Mydb.addingitem("Common items","Shavarma","https://cdn.whatsgabycooking.com/wp-content/uploads/Chicken-Shawarma-Stuffed-Pita.jpg",4.8,"Chicken and vegitables inside Kuboos","https://www.delish.com/cooking/recipe-ideas/a26092675/best-chicken-shawarma-recipe/");
        Mydb.addingitem("Common items","Butter Chicken","https://cafedelites.com/wp-content/uploads/2019/01/Butter-Chicken-IMAGE-27.jpg",4.6,"Fresh butter made chicken","https://cafedelites.com/butter-chicken/");
        Mydb.addingitem("Common items","Kanji/Rice porridge","https://mykitchentrials.files.wordpress.com/2011/10/img_03151.jpg?w=768g",4.9,"Rice with cherupayar including rice water","http://mykitchentreasure.blogspot.com/2013/10/perfect-dinner-for-malayali-kanjiyum.html");
    }

    public void addtolist(String string){
        Cursor cursor = Mydb.cur(string);
        while(cursor.moveToNext()){
            fd.add(new Food(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3),cursor.getString(4),cursor.getString(5)));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.districtsinmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.kasar:
                fd.clear();
                addtolist("Kasaragod");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.kann:
                fd.clear();
               // Toast.makeText(HomeActivity.this,"kannur selected",Toast.LENGTH_LONG).show();

                addtolist("Kannur");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.kozhi:
                fd.clear();
                addtolist("Kozhikode");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.way:
                fd.clear();
                addtolist("Wayanad");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.mal:
                fd.clear();
                addtolist("Malappuram");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.pala:
                fd.clear();
                addtolist("Palakkad");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.thri:
                fd.clear();
                addtolist("Thrissur");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.erna:
                fd.clear();
                addtolist("Ernakulam");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.iduk:
                fd.clear();
                addtolist("Idukki");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.kotta:
                fd.clear();
                addtolist("Kottayam");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.alappu:
                fd.clear();
                addtolist("Alappuzha");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.pathanam:
                fd.clear();
                addtolist("Pathanamthitta");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.kol:
                fd.clear();
                addtolist("Kollam");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.thiru:
                fd.clear();
                addtolist("Thiruvananthapuram");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;

            case R.id.comm:
                fd.clear();
                addtolist("Common items");
                customAdapter = new CustomAdapter(HomeActivity.this,fd);

                gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                relist.setLayoutManager(gridLayoutManager);
                relist.setAdapter(customAdapter);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}