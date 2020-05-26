#name = input('What is your name? ')
#print("Hello, " + name)

# print(2 ** 3) # 2^3 == 8

# print(7 / 3) # 2.3333333333333335
# print(7 // 3) # 5 div 3 == 1

# print(type(bin(5)))

# v = 1
# vAr = 'aaa'
# print(vAr)

# s = '''
#     multiple line
#     string
# '''

# print('"' + s + '"')

# s = 'string' + 123
# s += 123

# s = 'string' + str(123)
# print(s)

# weather = "It's \"kind of\" sunny\n"
# print(weather)

# print('012345'[::-2])
# print('Ahoj. Jak se mas? Dobre.'.capitalize())

# print("abc" * 3)

# print(bool([0]))

# li1 = [0,1,2,3,4,5,2,2]
# li2 = li1[:]
# li2[0] = 999
# li = list(range(2,5))
# print(li1)
# print(li2)
# print(li)

# di = {True: 1, 123: [], 'abc': {}}
# di['abc']['a'] = 1
# di.pop('abc')
# print(di)

# tu = (1,)
# print(tu[1:3])

# se = {1,2,3,3,3,3}
# se.add(100)
# se.add(1)
# se.add(0)
# se.add(5)
# print(5 in se)

# print([1,2] == [1,2])

# for i in "ahoj sveet!":
#     print(i)

# for num in range(5, 0, -1):
#     print('number:', num)

# a = 1

# if True:
#     x = 1

# def myfn():
#     global a
#     a = 2
#     x = 2
#     y = 2
#     z = 2

#     def myfn2():
#         nonlocal z
#         z = 3
#     myfn2()
#     return z

# z = myfn()

# print(a)    # 2
# print(x)    # 1
# # print(y)  # Error
# print(z)    # 3

# class MyObject:
    
#     classobj = 1

#     def __init__(self, name):
#         self.name = name
#         MyObject.classobj = 2

#     def mymethod(self, hello):
#         print(f'{hello}, {self.name}!')

#     @classmethod
#     def staticmethod(cls, text):
#         classobj = False
#         return cls(text)


# myobj = MyObject('abc')
# myobj.mymethod('Hello')    # Hello, abc!

# myobj = MyObject.staticmethod('cde')
# myobj.mymethod('Hello')    # Hello, cde!

class SuperClass:
    def mymethod(self):
        pass

class SubClass(SuperClass):
    def mymethod2(self):
        SuperClass.mymethod()

sub = SubClass()
sub.mymethod()