from pojo.Dish import Dish

import sqlite3

class DishDao:
    def __init__(self):
        self.path = "C:/Users/Administrator/Documents/Java/dishmanage/dish.db"
        self.conn = sqlite3.connect(self.path)

    def __del__(self):
        self.conn.close()


    def insert(self, dish):
        self.conn.execute("INSERT INTO dishes(name, category, recipe) VALUES ('%s','%s','%s')" %(dish.name, dish.category, dish.recipe))
        self.conn.commit()