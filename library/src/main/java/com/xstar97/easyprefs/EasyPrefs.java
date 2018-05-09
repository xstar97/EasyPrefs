package com.xstar97.easyprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Map;
import java.util.Set;

import static com.xstar97.easyprefs.Utils.isValid;

public class EasyPrefs
{
    private String TAG = EasyPrefs.class.getName();

    private String ERROR_PREFERENCE_OBJECT = "invalid object value!";

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
        return prefName;
    }
    private int getMode(){
        return mode;
    }
    private String getKey(){
        return key;
    }
    private Object getValue(){
        return value;
    }

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
        return null;
    }
    private SharedPreferences.Editor getEditor(){
        if(isValid(getPrefs)) {
            return getPrefs.edit();
        }
        return null;
    }

    public EasyPrefs setPreference(){
        boolean mPref = isValid(getPreferenceName());
        boolean mMode = getMode() == DEFAULT_PREF_MODE;

        if(!mPref || mMode) {
            this.getPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        }else {
            this.getPrefs = context.getSharedPreferences(getPreferenceName(), getMode());
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
}