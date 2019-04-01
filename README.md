# Lab3
This is lab3.

## Main：
![](/Screenshot/Main.jpg)

## AnimalList:
![](/Screenshot/AnimalList.jpg)

## AlertDialog:
![](/Screenshot/AlertDialog.jpg)

## Menu:
![](/Screenshot/Menu.jpg)
![](/Screenshot/Menu2.jpg)

## ActionMode:
![](/Screenshot/ActionMode.jpg)


## Code:

### AnimalsList:

#### Activity Code：
public class AnimalsListView extends Activity implements AdapterView.OnItemClickListener{
    private List<Animal> animalList = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list_view);
        initAnimals(); //初始化数据
        SimpleAdapter adapter = new SimpleAdapter(AnimalsListView.this,R.layout.animal_item,animalList);
        ListView listView = (ListView) findViewById(R.id.mylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    private  void initAnimals(){
        Animal cat = new Animal("Cat",R.drawable.cat);
        animalList.add(cat);
        Animal dog = new Animal("Dog",R.drawable.dog);
        animalList.add(dog);
        Animal elephant = new Animal("Elephant",R.drawable.elephant);
        animalList.add(elephant);
        Animal lion = new Animal("Lion",R.drawable.lion);
        animalList.add(lion);
        Animal monkey = new Animal("Monkey",R.drawable.monkey);
        animalList.add(monkey);
        Animal tiger = new Animal("Tiger",R.drawable.tiger);
        animalList.add(tiger);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //通过view获取其内部的组件，进而进行操作
        String text = (String) ((TextView)view.findViewById(R.id.animal_name)).getText();
        String showText = text ;
        view.setBackgroundResource(R.color.colorPrimaryDark);
        Toast.makeText(this, showText, Toast.LENGTH_LONG).show();
    }
}

#### Adapter Code:
public class SimpleAdapter extends ArrayAdapter {
    private final int resourceId;

    public SimpleAdapter(Context context, int textViewResourceId, List<Animal> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Animal animal = (Animal)getItem(position);//获取当前的Animal实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView av = (ImageView)view.findViewById(R.id.animal_image);//获取该布局内的图片视图
        TextView tv = (TextView)view.findViewById(R.id.animal_name);//获取该布局内的文本视图
        av.setImageResource(animal.getImageId());//为图片视图设置图片资源
        tv.setText(animal.getName());//为文本视图设置文本内容

        return view;

    }
}

### AlertDialog:

#### MyDialog Code:
public class MyDialog extends Dialog {

    public MyDialog(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        // 获取布局中的控件
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button btnSignin = (Button) findViewById(R.id.btn_signin);
        final Button btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnSignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dismiss();
            }
        });
    }
}

#### Layout Code:
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:background="#fff"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tv_title"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:background="#FBC635"
        android:gravity="center"
        android:text="Alert Dialog"
        android:textColor="#fff"
        android:textSize="30sp"
        android:textStyle="bold"
        android:visibility="visible" />

    <LinearLayout
        android:id="@+id/ll_content"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:gravity="center">

        <EditText
            android:id="@+id/username"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:hint="Username"
            android:inputType="text"
            android:singleLine="true"
            android:textSize="25sp"/>
        <EditText
            android:id="@+id/password"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:hint="Password"
            android:inputType="textPassword"
            android:singleLine="true"
            android:textSize="25sp"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:background="#E0E0E0"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btn_cancel"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:background="#FF8000"
            android:text="Cancel"
            android:textAllCaps="false"
            android:textColor="#fff"
            android:textSize="18sp"
            android:layout_weight="1" />

        <Button
            android:id="@+id/btn_signin"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:background="#FF4000"
            android:text="Sign in"
            android:textAllCaps="false"
            android:textColor="#000"
            android:textSize="18sp"
            android:layout_weight="1" />

    </LinearLayout>
</LinearLayout>
    
### MenuTest:

#### Menu Code:
public class MenuTest extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        txt = (TextView)findViewById(R.id.et_text);
        switch (mi.getItemId()){
            case R.id.font_10:
                txt.setTextSize(20);
                break;
            case R.id.font_16:
                txt.setTextSize(32);
                break;
            case R.id.font_20:
                txt.setTextSize(40);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                txt.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast =Toast.makeText(MenuTest.this,"这是普通单击项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

}

#### Menu.xml:
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <!--定义菜单项-->
    <item
        android:title="字体大小"
        >
        <!--子菜单-->
        <menu>
            <!--定义一组单选菜单项-->
            <group >
                <!--定义多个菜单项-->
                <item
                    android:id="@+id/font_10"
                    android:title="10号字"/>
                <item
                    android:id="@+id/font_16"
                    android:title="16号字"/>
                <item
                    android:id="@+id/font_20"
                    android:title="20号字"/>
            </group>
        </menu>
    </item>

    <!--定义一个普通菜单项-->
    <item
        android:id="@+id/plain_item"
        android:title="普通菜单项"/>

    <item
        android:title="字体颜色"
        >
        <menu>
            <!--定义一组普通菜单项-->
            <group>
                <!--定义两个菜单项-->
                <item
                    android:id="@+id/red_font"
                    android:title="红色" />
                <item
                    android:title="黑色"
                    android:id="@+id/black_font"/>
            </group>
        </menu>
    </item>
</menu>

### ActionMode:

#### ActionBar Code:
public class ContextActionMode extends AppCompatActivity {

    ListView listView;
    List<String> datas = new ArrayList<String>();
    ListViewAdapter adapter;
    ModeCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_action_mode);
        listView = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getData());
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        callback = new ModeCallback();
        listView.setMultiChoiceModeListener(callback);
    }

    class ModeCallback implements AbsListView.MultiChoiceModeListener {

        View actionBarView;
        TextView selectedNum;

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            return true;
        }

        //退出多选模式时调用
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
            listView.clearChoices();
        }

        //进入多选模式调用，初始化ActionBar的菜单和布局
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            getMenuInflater().inflate(R.menu.multiple_mode_menu, menu);
            if(actionBarView == null) {
                actionBarView = LayoutInflater.from(ContextActionMode.this).inflate(R.layout.actionbar_view, null);
                selectedNum = (TextView)actionBarView.findViewById(R.id.selected_num);
            }
            mode.setCustomView(actionBarView);
            return true;
        }

        //ActionBar上的菜单项被点击时调用
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // TODO Auto-generated method stub
            switch(item.getItemId()) {
                case R.id.select_all:
                    for(int i = 0; i < adapter.getCount(); i++) {
                        listView.setItemChecked(i, true);
                    }
                    updateSelectedCount();
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.unselect_all:
                    listView.clearChoices();
                    updateSelectedCount();
                    //adapter.notifyDataSetChanged();
                    break;
            }
            return true;
        }

        //列表项的选中状态被改变时调用
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position,
                                              long id, boolean checked) {
            // TODO Auto-generated method stub
            updateSelectedCount();
            mode.invalidate();
            adapter.notifyDataSetChanged();
        }

        public void updateSelectedCount() {
            int selectedCount = listView.getCheckedItemCount();
            selectedNum.setText(selectedCount + "");
        }
    }
}
