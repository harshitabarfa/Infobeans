class Ass3 
{
public static void main(String[] args) 
{
for (int i = 0; i < 3; i++) {

if (i == 0) 
{
System.out.println("Category 1: Electronics");
} 
else if (i == 1) 
{
System.out.println("Category 2: Clothing");
} 
else 
{
System.out.println("Category 3: Home Goods");
}

for (int j = 0; j < 5; j++) {
            
if (i == 0) 
{
if (j == 0) 
{
System.out.println("    Product 1: Laptop - $999");
} 
else if (j == 1) 
{
System.out.println("    Product 2: Smartphone - $799");
                    
} else if (j == 2) 
{
System.out.println("    Product 3: Headphones - $199");
}
else if (j == 3) 
{
System.out.println("    Product 4: Tablet - $349");
} 
else 
{
System.out.println("    Product 5: Smartwatch - $129");
}
} 
else if (i == 1) 
{
if (j == 0) 
{
System.out.println("    Product 1: T-shirt - $15");
} 
else if (j == 1) 
{
System.out.println("    Product 2: Jeans - $45");
} 
else if (j == 2) 
{
System.out.println("    Product 3: Jacket - $60");
} 
else if (j == 3) 
{
System.out.println("    Product 4: Socks - $5");
} 
else 
{
System.out.println("    Product 5: Shoes - $80");
}
} 
else 
{                    
if (j == 0) 
{
System.out.println("    Product 1: Sofa - $499");
} 
else if (j == 1) 
{
System.out.println("    Product 2: Coffee Table - $89");
} 
else if (j == 2) 
{
System.out.println("    Product 3: Lamp - $29");
} 
else if (j == 3) 
{
System.out.println("    Product 4: Rug - $59");
} else 
{
System.out.println("    Product 5: Curtains - $39");
}
}
}
System.out.println(); 
}
}
}