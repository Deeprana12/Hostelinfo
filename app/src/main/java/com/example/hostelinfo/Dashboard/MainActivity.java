package com.example.hostelinfo.Dashboard;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.example.hostelinfo.User.Login;
import com.example.hostelinfo.insideHostel.ashirwad.ashirwadCard;
import com.example.hostelinfo.insideHostel.darshan.darshanCard;
import com.example.hostelinfo.R;
import com.example.hostelinfo.insideHostel.nilkanth.nilkanthCard;
import com.example.hostelinfo.insideHostel.nisarg.nisargCard;
import com.example.hostelinfo.insideHostel.ohm.ohmCard;
import com.example.hostelinfo.insideHostel.rylcr.rylcrCard;
import com.example.hostelinfo.insideHostel.sahajanand.sahjaCard;
import com.example.hostelinfo.insideHostel.shreedeep.shreedeepCard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView cr1,cr2,cr3,cr4,cr5,cr6,cr7,cr8;
    FirebaseAuth firebaseAuth;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView hostelimage1 = (ImageView) findViewById(R.id.hostelimage1);
        Picasso.get().load("https://lh3.googleusercontent.com/p/AF1QipPG9KIIl6lzrbZFQe3LnXJywxtm8mDLQ3lq4U4=s1600-w1600").into(hostelimage1);



        ImageView hostelimage3 = (ImageView) findViewById(R.id.hostelimage3);
        Picasso.get().load("https://content3.jdmagicbox.com/comp/kheda/x9/9999p2694.2694.190814123949.a4x9/catalogue/nisarg-hostel-changa-kheda-kheda-hostel-for-boy-students-8svq73s6tb.jpg?clr=442222").into(hostelimage3);

//        ImageView hostelimage4 = (ImageView) findViewById(R.id.hostelimage4);
//        Picasso.get().load("d").into(hostelimage4);

        ImageView hostelimage5 = (ImageView) findViewById(R.id.hostelimage5);
        Picasso.get().load("https://darshanhostel.com/wp-content/uploads/2017/05/Darshan-Hostel-Entrance.jpg").into(hostelimage5);

//        ImageView hostelimage6 = (ImageView) findViewById(R.id.hostelimage6);
//        Picasso.get().load("https://api.time.com/wp-content/uploads/2016/03/game-of-thrones-jon-snow.jpg").into(hostelimage6);

        ImageView hostelimage7 = (ImageView) findViewById(R.id.hostelimage7);
        Picasso.get().load("http://www.sahajanandhostel.com/images/hostel/6.jpg").into(hostelimage7);
//
        ImageView hostelimage8 = (ImageView) findViewById(R.id.hostelimage8);
        Picasso.get().load("https://lh3.googleusercontent.com/IWgPDNJ32gF2yIdjv4NjLAXzJoID8MBxIXdtULCqHJ0ScL8FOx-WwJjh5CM7qIgrwLj20ZUx=w1080-h608-p-no-v0").into(hostelimage8);

        cr1 = (CardView) findViewById(R.id.c1);
        cr2 = (CardView) findViewById(R.id.c2);
        cr3 = (CardView) findViewById(R.id.c3);
        cr4 = (CardView) findViewById(R.id.c4);
        cr5 = (CardView) findViewById(R.id.c5);
        cr6 = (CardView) findViewById(R.id.c6);
        cr7 = (CardView) findViewById(R.id.c7);
        cr8 = (CardView) findViewById(R.id.c8);

        cr1.setOnClickListener(this);
        cr2.setOnClickListener(this);
        cr3.setOnClickListener(this);
        cr4.setOnClickListener(this);
        cr5.setOnClickListener(this);
        cr6.setOnClickListener(this);
        cr7.setOnClickListener(this);
        cr8.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.c5 :
                i = new Intent(this, darshanCard.class);
                startActivity(i);
                break;

            case R.id.c1 :
                i = new Intent(this, shreedeepCard.class);
                startActivity(i);
                break;

            case R.id.c2 :
                i = new Intent(this, nilkanthCard.class);
                startActivity(i);
                break;

            case R.id.c3 :
                i = new Intent(this, nisargCard.class);
                startActivity(i);
                break;

            case R.id.c4 :
                i = new Intent(this, ashirwadCard.class);
                startActivity(i);
                break;

            case R.id.c6 :
                i = new Intent(this, ohmCard.class);
                startActivity(i);
                break;

            case R.id.c7 :
                i = new Intent(this, sahjaCard.class);
                startActivity(i);
                break;

            case R.id.c8 :
                i = new Intent(this, rylcrCard.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_searchmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:{
//                firebaseAuth.signOut();
//                finish();
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        }

    return super.onOptionsItemSelected(item);
    }
}


//      productList = new ArrayList<>();
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        productList.add(
//                new Product(
//                        "4.3",
//                        "Shreedeep Hostel",
//                        "Ratings",
//                        "Distance: 1.7km",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.bus,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                        "4.2",
//                                "Nilkanth Hostel",
//                                "Ratings",
//                                "Distance: 3.2km",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.bus,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                        "4.0",
//                                "Nisarg Hostel",
//                                "Ratings",
//                                "Distance: 450m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.walking,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                                "3.8",
//                                "Ashirwad Hostel",
//                                "Ratings",
//                                "Distance: 800m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.walking,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                                "3.8",
//                                "Darshan Hostel",
//                                "Ratings",
//                                "Distance: 650m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.walking,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                        "3.8",
//                                "Ohm Hostel",
//                                "Ratings",
//                                "Distance: 850m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.walking,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                        "3.5",
//                                "Sahajanand Hostel",
//                                "Ratings",
//                                "Distance: 500m",
//                        R.drawable.sahja,
//                        R.drawable.university,
//                        R.drawable.walking,
//                        R.drawable.star));
//
//        productList.add(
//                new Product(
//                        "3.8",
//                                "Royal Care Hostel",
//                                "Ratings",
//                                "Distance: 550m",
//                        R.drawable.royalcare,
//                        R.drawable.university,
//                        R.drawable.walking,
//                        R.drawable.star));
//
//    ProductAdapter adapter = new ProductAdapter(this,productList);
//        recyclerView.setAdapter(adapter);
//    }
//}


//
//        FirebaseRecyclerAdapter<fetchinginfo, firebaseViewHolder> firebaseRecyclerAdapter =
//                new FirebaseRecyclerAdapter<fetchinginfo, firebaseViewHolder>(options) {
//                    @Override
//                    protected void onBindViewHolder(@NonNull firebaseViewHolder holder, int position, @NonNull fetchinginfo model) {
//                        holder.setDetails(getApplication(), model.getDist(), model.getHimage(), model.getHname(), model.getRates(), model.getRating()
//                                , model.getStar(), model.getTransimg(), model.getUimg());
//                    }
//
//                    @NonNull
//                    @Override
//                    public firebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//                        View view = LayoutInflater.from(parent.getContext())
//                                .inflate(R.layout.list_layout, parent, false);
//
//                        return new firebaseViewHolder(view);
//
//                    }
//                };
//        firebaseRecyclerAdapter.startListening();
//        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
//
//
//        FirebaseRecyclerAdapter<fetchinginfo,firebaseViewHolder> firebaseRecyclerAdapter =
//                new FirebaseRecyclerAdapter<fetchinginfo, firebaseViewHolder>() {
//                    @Override
//                    protected void onBindViewHolder(@NonNull firebaseViewHolder firebaseViewHolder, int i, @NonNull fetchinginfo fetchinginfo) {
//
//                    }
//
//                    @NonNull
//                    @Override
//                    public firebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                        return null;
//                    }
//                }



//    private RecyclerView recyclerView;
//    firebaseViewHolder adapter; // Create Object of the Adapter class
//    DatabaseReference mbase;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mbase = FirebaseDatabase.getInstance().getReference();
//
//        recyclerView = findViewById(R.id.recyclerView);
//
//        // To display the Recycler view linearly
//        recyclerView.setLayoutManager(
//                new LinearLayoutM
//                anager(this));
//
//        // It is a class provide by the FirebaseUI to make a
//        // query in the database to fetch appropriate data
//        FirebaseRecyclerOptions<fetchinginfo> options
//                = new FirebaseRecyclerOptions.Builder<fetchinginfo>()
//                .setQuery(mbase, fetchinginfo.class)
//                .build();
//        // Connecting object of required Adapter class to
//        // the Adapter class itself
//        adapter = new firebaseViewHolder(options);
//        // Connecting Adapter class with the Recycler view*/
//        recyclerView.setAdapter(adapter);
//    }
//
//    // Function to tell the app to start getting
//    // data from database on starting of the activity
//    @Override protected void onStart()
//    {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    // Function to tell the app to stop getting
//    // data from database on stoping of the activity
//    @Override protected void onStop()
//    {
//        super.onStop();
//        adapter.stopListening();
//    }
//}


//        FirebaseRecyclerAdapter<fetchinginfo, firebaseViewHolder> firebaseRecyclerAdapter =
//                new FirebaseRecyclerAdapter<fetchinginfo, firebaseViewHolder>(options) {
//                    @Override
//                    protected void onBindViewHolder(@NonNull firebaseViewHolder holder, int position, @NonNull fetchinginfo model) {
//                        holder.setDetails(getApplication(), model.getDist(), model.getHimage(), model.getHname(), model.getRates(), model.getRating()
//                                , model.getStar(), model.getTransimg(), model.getUimg());
//                    }
//
//                    @NonNull
//                    @Override
//                    public firebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//                        View view = LayoutInflater.from(parent.getContext())
//                                .inflate(R.layout.list_layout, parent, false);
//
//                        return new firebaseViewHolder(view);
//
//                    }
//                };
//        firebaseRecyclerAdapter.startListening();
//        mRecyclerView.setAdapter(firebaseRecyclerAdapter);


//        FirebaseRecyclerAdapter<fetchinginfo,firebaseViewHolder> firebaseRecyclerAdapter =
//                new FirebaseRecyclerAdapter<fetchinginfo, firebaseViewHolder>() {
//                    @Override
//                    protected void onBindViewHolder(@NonNull firebaseViewHolder firebaseViewHolder, int i, @NonNull fetchinginfo fetchinginfo) {
//
//                    }
//
//                    @NonNull
//                    @Override
//                    public firebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                        return null;
//                    }
//                }

    //        productList = new ArrayList<>();
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        productList.add(
//                new Product(
//                        4.3,
//                        "Shreedeep Hostel",
//                        "Ratings",
//                        "Distance: 1.7km",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.bus));
//
//        productList.add(
//                new Product(
//                        4.2,
//                        "Nilkanth Hostel",
//                        "Ratings",
//                        "Distance: 3.2km",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.bus));
//
//        productList.add(
//                new Product(
//                        4.0,
//                        "Nisarg Hostel",
//                        "Ratings",
//                        "Distance: 450m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.walking));
//
//        productList.add(
//                new Product(
//                        3.8,
//                        "Ashirwad Hostel",
//                        "Ratings",
//                        "Distance: 800m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.walking));
//
//        productList.add(
//                new Product(
//                        3.8,
//                        "Darshan Hostel",
//                        "Ratings",
//                        "Distance: 650m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.walking));
//
//        productList.add(
//                new Product(
//                        3.8,
//                        "Ohm Hostel",
//                        "Ratings",
//                        "Distance: 850m",
//                        R.drawable.nisarg,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.walking));
//
//        productList.add(
//                new Product(
//                        3.5,
//                        "Sahajanand Hostel",
//                        "Ratings",
//                        "Distance: 500m",
//                        R.drawable.sahja,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.walking));
//
//        productList.add(
//                new Product(
//                        3.8,
//                        "Royal Care Hostel",
//                        "Ratings",
//                        "Distance: 550m",
//                        R.drawable.royalcare,
//                        R.drawable.university,
//                        R.drawable.star,
//                        R.drawable.walking));
//
//        adapter = new ProductAdapter(this,productList);
//        recyclerView.setAdapter(adapter);


