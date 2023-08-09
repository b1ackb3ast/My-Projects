from cryptography.fernet import Fernet, InvalidToken

class PasswordManager:
    
    # constructor for PasswordManager
    def __init__(self):
        self.key = None
        self.password_file= None
        self.password_dict = {}

    # key is being generated
    def create_key(self, path):
        self.key = Fernet.generate_key()
        with open(path, 'wb') as f:
            f.write(self.key)



    def load_key(self, path):
        with open(path, 'rb') as f:
            self.key = f.read()

    def create_password_file(self, path, initial_values=None):
        self.password_file = path

        if initial_values is not None:
            for key, values in initial_values.items():
                self.add_password(key, values)
        
    def load_password_file(self, path):
        self.password_file = path

        with open(path, 'r') as f:
            for line in f:
                site, encrypted = line.split(":")
                self.password_dict[site] = Fernet(self.key).decrypt(encrypted.encode()).decode()

    def add_password(self, site, password):
        self.password_dict[site] = password

        if self.password_file is not None:
            with open(self.password_file, 'a+') as f:
                encrypted = Fernet(self.key).encrypt(password.encode());
                f.write(site + ":" + encrypted.decode() + "\n")


    def get_password(self, site):
        return self.password_dict[site]
            

def main():
    password = {
        "gmail1" : "kevinksaji10@gmail.com, njstgos3#",
        "gmail2" : "kevinsaji95@gmail.com, njstgos3",
        "yahoo" : "kevinsaji10@yahoo.com, njstgos3", 
        "outlook" : "kevinsaji@outlook.sg, njstgos3#", 
        "laptop" : "njstgos3#", 
        "phone" : "njstgos3#", 
        "epic games" : "kevinsaji@outlook.sg, Njstgos3#", 
        "insta1" : "rea1r0ckstar, njstgos3#", 
        "insta2" : "kevinsaji10, Ighockey123", 
        "riot games" : "rea1r0ckstar, Njstgos3#", 
        "discord" : "kevinksaji10@gmail.com, njstgos3#"
        

    }

    # user interface
    pm = PasswordManager()
    print("""What do you want to do?
          (1) Create a new key
          (2) Load an existing key
          (3) Create new password file
          (4) Load existing password file
          (5) Add a new password
          (6) Getting a password
          (q) Quit
          """)
    done = False
    while not done:
        try:
            choice = input("Enter your choice: ")
            if choice == "1":
                path = input("Enter new key name: ")
                pm.create_key(path)
            elif choice =="2":
                path = input("Enter key name: ")
                pm.load_key(path)
            elif choice =="3":
                path = input("Enter new password file name: ")
                pm.create_password_file(path, password)
            elif choice =="4":
                path = input("Enter password file name: ")
                pm.load_password_file(path)
            elif choice =="5":
                site = input("Enter the site: ")
                password = input("Enter the password: ")
                pm.add_password(site, password)
                print("Password added sucessfully :)")
            elif choice == "6":
                site = input("Enter the site: ")
                print(f"Password for {site} is {pm.get_password(site)}")
            elif choice == "q":
                done = True
                print("Bye :)")
            else:
                print("Invalid choice :(")
        except InvalidToken:
            print("You have entered an invalid key, Try again hacker.")
        except KeyError:
            print("No entry found :(")




if __name__ == "__main__":
    main()

