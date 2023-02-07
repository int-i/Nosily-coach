import random
import numpy as np
import csv
import matplotlib.pyplot as plt

# Create a list to store the data
data = []
m_weight_graph = []
m_redu_graph = []
f_weight_graph = []
f_redu_graph = []
total_reduced_weight = 0
total_weight = 0
total_fat_per = 0
# Generate data for 10,000 people
for i in range(30000):
    # Create a dictionary to store the person's data
    person = {}

    gen = random.choice(["male", "female"])
    rand_fat = round(random.gauss(0, 4),2)
    m_weight = round(random.gauss(78, 5),2)
    f_weight = round(random.gauss(57, 5),2)
    ex_time = round(random.gauss(8, 2.5),1)
    if ex_time < 0:
        ex_time = 0
    m_cal_in = round(random.gauss(2250, 250),1)
    f_cal_in = round(random.gauss(1950, 250),1)
    reduced_weight = round(random.gauss(0, 0.7),2)
    age = int(random.gauss(30, 14))
    if age < 19:
        age = 19
    fat_per = 22 + rand_fat
    func_redu_m_weight = round(((m_weight*(fat_per*fat_per/10000)/20) + ((ex_time-6)/5) + ((2600-m_cal_in)//180) 
                        + ((int(age<25))*0.3) + reduced_weight)*(0.75 + (m_weight-60)/400), 1)
    func_redu_f_weight = round(1.5 + ((f_weight*(fat_per*fat_per/10000)/20) + ((ex_time-4)/5) + ((1800-f_cal_in)//180) 
                        + ((int(age<25))*0.3) + reduced_weight)*(0.7 + (f_weight-40)/300), 1)
    if (gen == "male"):
        weight = m_weight
        cal_in = m_cal_in
        func_redu_weight = func_redu_m_weight
    else:
        weight = f_weight
        cal_in = f_cal_in
        func_redu_weight = func_redu_f_weight
    
    m_weight_graph.append(m_weight)
    m_redu_graph.append(func_redu_m_weight)
    f_weight_graph.append(f_weight)
    f_redu_graph.append(func_redu_f_weight)

    person["Gender"] = gen
    person["Primary weight"] = weight
    person["Exercise hour per week"] = ex_time
    person["Calorie intake per day"] = cal_in
    person["Age"] = age
    person["Starting body fat percentage"] = fat_per
    person["Reduced weight"] = func_redu_weight
    total_reduced_weight += func_redu_weight
    total_fat_per += fat_per
    total_weight += weight
    # Add the person's data to the list
    data.append(person)
print(total_weight/30000)
print(total_fat_per/30000)
print(total_reduced_weight/30000)

# Plot the data
plt.scatter(m_weight_graph, m_redu_graph, s=3)
plt.scatter(f_weight_graph, f_redu_graph, s=3)

# Add labels and title
plt.xlabel('weight')
plt.ylabel('redu_weight')
plt.title('male & female')
# Show the plot
plt.show()


# Write the data to a CSV file
with open("weight_loss_data.csv", "w") as f:
    writer = csv.DictWriter(f, fieldnames=["Primary weight", "Exercise hour per week", "Calorie intake per day", 
    "Age", "Gender", "Starting body fat percentage", "Reduced weight"])
    writer.writeheader()
    writer.writerows(data)