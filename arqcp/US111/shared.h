#ifndef SHARED_H
#define SHARED_H

#define TEMPERATURES_SENSOR_INTERVAL 2000
#define VELOCITY_SENSOR_INTERVAL 10000
#define DIRECTION_SENSOR_INTERVAL 10000
#define PLUVIO_SENSOR_INTERVAL 10000
#define SOIL_HUMIDITY_SENSOR_INTERVAL 10000
#define AIR_HUMIDITY_SENSOR_INTERVAL 10000

extern const char TEMP_SENSOR_MAX_VARIATION;
extern const char TEMP_BASE_VALUE;
extern const char VELC_SENSOR_MAX_VARIATION;
extern const char PLUV_CONTRIB_HUMD;
extern const char SOIL_HUMD_SENSOR_MAX_VARIATION;
extern const char SOIL_HUMD_SENSOR_RAINING_MAX_VARIATION;
extern const char VELC_SENSOR_DIR_WIND_MAX_VARIATION;
extern const char PLUVIO_SENSOR_MAX_VARIATION;
extern const char HIGH_TEMP_DEFAULT;
extern const char PLUVIO_SENSOR_MAX_VARIATION_HIGH_TEMP;

#define N_OF_TEMP_SENSORS 3
#define N_OF_VELOCITY_SENSORS 3
#define N_OF_DIRECTION_SENSORS 3
#define N_OF_PLUVIO_SENSORS 3
#define N_OF_SOIL_HUMIDITY_SENSORS 3
#define N_OF_AIR_HUMIDITY_SENSORS 3

#define SEC_IN_DAY 86400

#define NUM_TEMPERATURE_REGISTERS SEC_IN_DAY / TEMPERATURES_SENSOR_INTERVAL
#define NUM_VEL_WIND_REGISTERS SEC_IN_DAY / VELOCITY_SENSOR_INTERVAL
#define NUM_DIR_WIND_REGISTERS SEC_IN_DAY / DIRECTION_SENSOR_INTERVAL
#define NUM_PLUVIO_REGISTERS SEC_IN_DAY / PLUVIO_SENSOR_INTERVAL
#define NUM_SOIL_HUMIDITY_REGISTERS SEC_IN_DAY / SOIL_HUMIDITY_SENSOR_INTERVAL
#define NUM_AIR_HUMIDITY_REGISTERS SEC_IN_DAY / AIR_HUMIDITY_SENSOR_INTERVAL

enum sensor_types {
    TEMPERATURE_SENSOR_TYPE,
    VELOCITY_SENSOR_TYPE,
    DIR_WIND_SENSOR_TYPE,
    PLUVIO_SENSOR_TYPE,
    SOIL_HUMIDITY_SENSOR_TYPE,
    AIR_HUMIDITY_SENSOR_TYPE
};

#define NUM_OF_SENSORS 6

// LIMITS
#define UPPER_LIMIT_TEMPERATURE 25
#define LOWER_LIMIT_TEMPERATURE 0
#define UPPER_LIMIT_VELOCITY 50
#define LOWER_LIMIT_VELOCITY 0
#define UPPER_LIMIT_DIR_WIND 359
#define LOWER_LIMIT_DIR_WIND 0
#define UPPER_LIMIT_PLUVIO 30
#define LOWER_LIMIT_PLUVIO 0
#define UPPER_LIMIT_SOIL_HUMIDITY 100
#define LOWER_LIMIT_SOIL_HUMIDITY 0
#define UPPER_LIMIT_AIR_HUMIDITY 100
#define LOWER_LIMIT_AIR_HUMIDITY 0

#define MAX_INCORRECT_READS 3
// END OF LIMITS

#endif

