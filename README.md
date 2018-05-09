# EasyPrefs

[![](https://jitpack.io/v/Xstar97/EasyPrefs.svg)](https://jitpack.io/#Xstar97/EasyPrefs)

     
     implementation 'com.github.Xstar97:EasyPrefs:v1.0'

    //default put; String
        new EasyPrefs(context)
                .setPreference()
                .setKey("key1")
                .setValue("hello")
                .put();
                
                
    //default put; boolean
        new EasyPrefs(context)
                .setPreference()
                .setKey("key2")
                .setValue(true)
                .put();
                
                
    //default put; Set<String>
        HashSet<String> data_set = new HashSet<>();
        data_set.add("A");
        data_set.add("B");
        data_set.add("C");
        data_set.add("D");
        data_set.add("E");
        data_set.add("F");

        new EasyPrefs(context)
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .put();
                
                
    //default put; Int
        new EasyPrefs(context)
                .setPreference()
                .setKey("key4")
                .setValue(100)
                .put();
                
                
    //default put; Float
        new EasyPrefs(context)
                .setPreference()
                .setKey("key5")
                .setValue(100.0F)
                .put();
    
    
    //default put; Long
        new EasyPrefs(context)
                .setPreference()
                .setKey("key6")
                .setValue(10L)
                .put();
                
                
    //default get; String
        String string = (String) new EasyPrefs(context)
                .setPreference()
                .setKey("key1")
                .setValue("noo....")
                .get();
    
    
    //default get; boolean
        boolean boolean = (boolean) new EasyPrefs(context)
                .setPreference()
                .setKey("key2")
                .setValue(false)
                .get();
                
                
         //default get; Set<String>
        HashSet<String> data_set = new HashSet<>();
        data_set.add("S");
        data_set.add("H");
        data_set.add("I");
        data_set.add("T");
        
        Set<String> set = (Set<>) new EasyPrefs(context)
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .get();
                
                
    //default get; Int
        Int int = (Integer) new EasyPrefs(context)
                .setPreference()
                .setKey("key4")
                .setValue(-1)
                .get();
                
                
    //default get; Float
        Float float = (Float) new EasyPrefs(context)
                .setPreference()
                .setKey("key5")
                .setValue(1.0F)
                .get();
                
                
    //default get; Long
        Long long = (Long) new EasyPrefs(context)
                .setPreference()
                .setKey("key6")
                .setValue(100L)
                .get();


    //custom put; String
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key1")
                .setValue("hello")
                .put();
                
                
    //custom put; Boolean
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key2")
                .setValue(true)
                .put();
   
   
    //custom put; Set<String>
        HashSet<String> data_set = new HashSet<>();
        data_set.add("A");
        data_set.add("B");
        data_set.add("C");
        data_set.add("D");
        data_set.add("E");
        data_set.add("F");

        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .put();
                
                
    //custm put; Int
        new EasyPrefs(context)
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key4")
                .setValue(100)
                .put();
                
                
    //custom put; Float
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key5")
                .setValue(100.0F)
                .put();
                
                
    //custom put; Long
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key6")
                .setValue(10L)
                .put();
                

    //custom get; String value
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key1")
                .setValue("noo....")
                .get();
                
                
    //custom get; boolean value
        new EasyPrefs(context)
                .setPreference()
                .setKey("key2")
                .setValue(false)
                .get();
    
    
    //custom get; Set<String> value
        HashSet<String> data_set = new HashSet<>();
        data_set.add("S");
        data_set.add("H");
        data_set.add("I");
        data_set.add("T");

        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .get();
                
                
    //custom get; Int value
        return (Integer) new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key4")
                .setValue(-1)
                .get();
                
                
    //custom get; Float value
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key5")
                .setValue(1.0F)
                .get();
                
                
    //custom get; Long value
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key6")
                .setValue(100L)
                .get();
                
                
    //default get all
        new EasyPrefs(context)
                .setPreference()
                .getAll();


    //custom get all
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .getAll();
                
                
    //default clear value
        new EasyPrefs(context)
                .setPreference()
                .setKey("key1")
                .clearValue();
    
    
    //default clear all
        new EasyPrefs(context)
                .setPreference()
                .clearAll();
              
              
    //custom clear value
    new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key1")
                .clearValue();
                
                
        //custom clear all
        new EasyPrefs(context)
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .clearAll();
