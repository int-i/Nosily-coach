# Importing the libraries
import pandas as pd
import tensorflow as tf

# Data Preprocessing

# Importing the dataset
dataset = pd.read_csv('weight_loss_data.csv')
X = dataset.iloc[:, :-1].values
y = dataset.iloc[:, -1].values

# Label Encoding the "Gender" column
from sklearn.preprocessing import LabelEncoder
le = LabelEncoder()
X[:,4] = le.fit_transform(X[:,4])

# Splitting the dataset into the Training set and Test set
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

#Feature Scaling
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)

# Building the ANN
ann = tf.keras.models.Sequential()

ann.add(tf.keras.layers.Dense(units=12, activation='relu'))
ann.add(tf.keras.layers.Dense(units=12, activation='relu'))
ann.add(tf.keras.layers.Dense(units=12, activation='relu'))
ann.add(tf.keras.layers.Dense(units=12, activation='relu'))
ann.add(tf.keras.layers.Dense(units=12, activation='tanh'))
ann.add(tf.keras.layers.Dense(units=12, activation='tanh'))

ann.add(tf.keras.layers.Dense(units=1, activation='linear'))

# Training the ANN
ann.compile(optimizer = 'adam', loss = 'mean_squared_error', metrics=['mse'])

ann.fit(X_train, y_train, batch_size = 32, epochs = 60)

ann.save("weight_loss_ann.h5")