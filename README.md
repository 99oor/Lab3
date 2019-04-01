# Lab3
This is lab3.

## 主页面：
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


## 代码：

### AnimalsList:

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

