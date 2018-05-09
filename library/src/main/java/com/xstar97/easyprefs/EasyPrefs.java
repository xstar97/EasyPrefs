package com.xstar97.easyprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Map;
import java.util.Set;

import static com.xstar97.easyprefs.Utils.isValid;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class EasyPrefs
{
    private String TAG = EasyPrefs.class.getName();

    private Context context;
    private SharedPreferences getPrefs;

    private int DEFAULT_PREF_MODE = -1;

    private String prefName = null;
    private int mode = DEFAULT_PREF_MODE;

    private String key = null;
    private Object value = null;

    public EasyPrefs setPreferenceName(String name){
        this.prefName = name;
        return this;
    }
    public EasyPrefs setMode(int mode){
        this.mode = mode;
        return this;
    }

    public EasyPrefs setKey(String key){
        this.key = key;
        return this;
    }
    public EasyPrefs setValue(Object value){
        this.value = value;
        return this;
    }

    private String getPreferenceName(){
        if(isValid(prefName)) {
            return prefName;
        }
        else {
            Log.d(TAG_PREF, ERROR_PREFERENCE_NAME);
            return null;
        }
    }
    @SuppressWarnings("ConstantConditions")
    private int getMode(){
        if(isValid(mode)) {
            return mode;
        }
        else {
            Log.d(TAG_MODE, ERROR_PREFERENCE_MODE);
            return -1;
        }
    }
    private String getKey(){
        if(isValid(key)) {
            return key;
        }
        else {
            Log.d(TAG_KEY, ERROR_PREFERENCE_KEY);
            return null;
        }
    }
    private Object getValue(){
        if(isValid(value)) {
            return value;
        }
        else {
            Log.d(TAG_VALUE, ERROR_PREFERENCE_OBJECT);
            return null;
        }
    }

    private String TAG_PREF = "Preference";
    private String TAG_EDITOR = "Preference.Editor";
    private String TAG_NAME = "Preference.Name";
    private String TAG_MODE = "Preference.Mode";
    private String TAG_KEY = "Preference.Key";
    private String TAG_VALUE = "Preference.Value";

    private String ERROR_PREFERENCE = "SharedPreferences method is null!";
    private String ERROR_PREFERENCE_EDITOR = "SharedPreferences Editor method is null!";
    private String ERROR_PREFERENCE_NAME = "SharedPreferences method 'NAME' is null!";
    private String ERROR_PREFERENCE_MODE = "SharedPreferences method 'MODE' is 'null'!";
    private String ERROR_PREFERENCE_KEY = "SharedPreferences method 'KEY' is null!";
    private String ERROR_PREFERENCE_OBJECT = "Object not accepted for sharedPreferences";

    private String PREFERENCE_DEFAULT = "Setting SharedPreferences with DEFAULT values...";
    private String PREFERENCE_CUSTOM = "Setting SharedPreferences with CUSTOM values...";

    /**
     * The Mode private method.
     *
     * <p>
     * File creation mode: the default mode, where the created file can only be accessed by the calling application.
     */
    public static int MODE_PRIVATE = 0;

    /**
     * The Mode world readable method.
     *
     * <p>
     * Creating world-readable files is very dangerous, and likely to cause security holes in applications.
     *
     * @deprecated
     * This constant was deprecated in API level 17.
     */
    public static int MODE_WORLD_READABLE = 1;

    /**
     * The Mode world writeable method.
     *
     * <p>
     * Creating world-writable files is very dangerous, and likely to cause security holes in applications.
     *
     * @deprecated
     * This constant was deprecated in API level 17.
     */
    public static int MODE_WORLD_WRITEABLE = 2;

    /**
     * The Mode multi process method.
     *
     * <p>
     * This method will check for modification of preferences even if the sharedpreference instance has already been loaded
     */
    public static int MODE_MULTI_PROCESS = 4;

    /**
     * The Mode append method.
     *
     * <p>
     * This will append the new preferences with the already exisiting preferences
     */
    public static int MODE_APPEND = 32768;

    /**
     * The Mode enable write ahead logging method.
     *
     * <p>
     * Database open flag. When it is set , it would enable write ahead logging by default
     */
    public static int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;

    public EasyPrefs(Context context) {
        this.context = context;
    }

    private SharedPreferences getPref(){
        if(isValid(getPrefs)) {
            return getPrefs;
        }
        else {
            Log.d(TAG_PREF, ERROR_PREFERENCE);
            return null;
        }
    }
    private SharedPreferences.Editor getEditor(){
        if(isValid(getPref())) {
            return getPref().edit();
        }else {
            Log.d(TAG_PREF, ERROR_PREFERENCE_EDITOR);
            return null;
        }
    }

    public EasyPrefs setPreference(){
        if(isPreferenceCustom()){
            Log.d(TAG_PREF, PREFERENCE_CUSTOM);
            this.getPrefs = context.getSharedPreferences(getPreferenceName(), getMode());
        }
        else {
            Log.d(TAG_PREF, PREFERENCE_DEFAULT);
            this.getPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return this;
    }

    /**
     * Get object method.
     *
     * @return the object
     *
     * <p><ul>
     * <li> String
     * <li> Boolean
     * <li> Set<String>
     * <li> Integer
     * <li> Float
     * <li> Long
     * <li> Object
     * </ul><p>
     *
     */
    public Object get() {
        try {
            Object defaultValue = getValue();

            Get get = new Get(getPref(), getKey(), defaultValue);

            if (defaultValue instanceof String) {
                return get.getString();
            } else if (defaultValue instanceof Boolean) {
                return get.getBoolean();
            } else if (defaultValue instanceof Set<?>) {
                return get.getStringSet();
            } else if (defaultValue instanceof Integer) {
                return get.getInt();
            } else if (defaultValue instanceof Float) {
                return get.getFloat();
            } else if (defaultValue instanceof Long) {
                return get.getLong();
            } else {
                throw new ClassCastException(TAG.getClass().getName() + ": " + ERROR_PREFERENCE_OBJECT + "\n" + "v: " + defaultValue);
            }
        }catch (ClassCastException cce){
            Log.e(TAG, cce.getMessage());
            return null;
        }catch (NullPointerException npe){
            Log.e(TAG, npe.getMessage());
            return null;
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    /**
     * Gets all.
     *
     * <p>
     * This Map<String, ?> method will return ALL values from sharedPreferences
     *
     * @return all
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getAll() {
        try {
            return (Map<String, Object>) new Get(getPref()).getAll();
        }catch (NullPointerException npe){
            Log.e(TAG, npe.getMessage());
            return null;
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    /**
     * Put method.
     *
     * <p>
     * This method saves the generic value in your SharePreferences.
     *
     * <p><ul>
     * <li> String
     * <li> Boolean
     * <li> Set<String>
     * <li> Integer
     * <li> Float
     * <li> Long
     * </ul><p>
     *
     */
    public final void put() {
        try {
            Object putValue = getValue();

            Put put = new Put(getEditor(), getKey(), getValue());

            if (putValue instanceof String) {
                put.putString();
            } else if (putValue instanceof Boolean) {
                put.putBoolean();
            } else if (putValue instanceof Set<?>) {
                put.putStringSet();
            } else if (putValue instanceof Integer) {
                put.putInt();
            } else if (putValue instanceof Float) {
                put.putFloat();
            } else if (putValue instanceof Long) {
                put.putLong();
            } else {
                throw new ClassCastException(TAG.getClass().getName() + ": " + ERROR_PREFERENCE_OBJECT);
            }
            }catch(ClassCastException cce){
            Log.e(TAG, cce.getMessage());
            }catch(NullPointerException npe){
            Log.e(TAG, npe.getMessage());
            }catch(Exception e){
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * Clear value method.
     *
     * <p>
     * This method clears the specific value by key from SharedPreferences.
     *
     */
    public final void clearValue(){
        try {
            new Put(getEditor(), getKey()).clearValue();
        }catch (NullPointerException npe){
            Log.e(TAG, npe.getMessage());
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * Clear all method.
     *
     * <p>
     * This method clears ALL values from SharedPreferences.
     */
    public final void clearAll(){
        try {
            new Put(getEditor()).clearAll();
        }catch (NullPointerException npe){
            Log.e(TAG, npe.getMessage());
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }

    private boolean isPreferenceCustom(){
        boolean mPref = isValid(getPreferenceName());
        boolean mMode = getMode() != DEFAULT_PREF_MODE;

        return mPref && mMode;
    }
}