package application;
import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;



public class Inte {
	 static String[] d;
	// @SuppressWarnings({ })
	static
	Dictionary <String,String>data= new Hashtable<>();
	   int s=0;
	 static  String[] val;
	 static String[] loop;
	 static String[] result;
	 static int count=0;
     static   int f=0;
     static int index=-1;
  static   MyDynamicStack stack[] =new MyDynamicStack[10]; 
      static String[] Names = new String[10]; 
	 //float data[]= new float[50];
	 //static String[] string= new String[200];
	  boolean flag;
    static char symbol;
public static void main(String[] args) 
{ 
	

BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
String pass = "";

try 
{ 
System.out.println("Enter your name");    
String name=in.readLine();   
System.out.println("Welcome "+name);
System.out.println("Enter 'stop' to exit .....\n"); 
Sym:
while(!pass.equalsIgnoreCase("stop")) 
{ 
//System.out.println("->"); 
//showMenu();
	
	
pass = in.readLine();

//Scanner sc = new Scanner(System.in);

flow(pass);
continue Sym;

    
        }
}
catch (IOException e) 
{  
  e.printStackTrace();
  }

}




private static String flow(String pass) {
	// TODO Auto-generated method stub
	String op;
	int len=pass.length();
	try {
	for(int i=0;i<len;i++)
	{  if(!Character.isLetterOrDigit(pass.charAt(i))&& !Character.isSpaceChar(pass.charAt(i)))
	    {  //System.out.println(pass.charAt(i)+"\n");
	    symbol=pass.charAt(i);
	    if(symbol=='|') {  String keyname=pass.substring(0, i); 
	    //System.out.println(keyname);
	           if(keyname.equals("STACK")) {stack(pass,i);i=len;}
	                 else {System.out.println("Syntax error : use keyword (STACK)"); i=len;}

	                               }
	             else if((pass.charAt(i)=='-' || pass.charAt(i)=='<' ) && (pass.charAt(i+1)=='-' || pass.charAt(i+1)=='>' ))
	                    {stack_op(pass,pass.charAt(i+1),i+1); i=len;}
	           
	             else if(symbol==':') {   	loop = pass.split("\\:",3);
		          	looping(loop); return "none";}
	    
	        else {
	        	//System.out.println("  Syntax Error \n");i=len;
	        switch(symbol)     
	      { 
	   case '+':      //i=len; 
		              val=pass.split("\\+");
		              if(pass.charAt(i+1)=='+') {     float inc=Float.valueOf(data.get(val[0]))+1;
		            	                              data.put(val[0], Float.toString(inc));i=len;
		            	                              } 
		              else { result=convert(val);
	                           //result[0].getClass().getName();
	                              //System.out.println(Float.valueOf(result[0]));
	               // System.out.println(Float.valueOf(result[1]));
		              op=Float.toString(Float.valueOf(result[0])+Float.valueOf(result[1]));
		              return op;
	                  //System.out.println(  Float.toString(Float.valueOf(result[0])+Float.valueOf(result[1])) );
		              }
		            
	                   	                   
	    case '-':         //i=len;       
	    	                          val=pass.split("\\-");
	    	                     if(pass.charAt(i+1)=='-') { 
	    	                   
	    	                    	 float inc=Float.valueOf(data.get(val[0]))-1;
	    	                            data.put(val[0], Float.toString(inc));i=len;
	    	                            } 
	    	                     else {
	                          result=convert(val);  
	                          op=Float.toString(Float.valueOf(result[0])-Float.valueOf(result[1]));
	    		              return op;
	                        //System.out.println(Float.toString(Float.valueOf(result[0])-Float.valueOf(result[1])) );
	                          }
	                  
	     case '*':       //i=len;    
	    	          val=pass.split("\\*");
	   
	                  result=convert(val);
	                  op=Float.toString(Float.valueOf(result[0])*Float.valueOf(result[1]));
		              return op;
	                   //System.out.println(Float.toString(Float.valueOf(result[0])*Float.valueOf(result[1])) );
	                  
	      case '/':          //i=len;     
	    	              val=pass.split("\\/");
	       
	                      result=convert(val);
	                      if(Float.valueOf(result[1])==0.0) {System.out.println("Division by 0 Error\n");
	                       }
	                      else {  op=Float.toString(Float.valueOf(result[0])/Float.valueOf(result[1]));
			              return op;
			              }
	                     //  System.out.println(Float.toString(Float.valueOf(result[0])/Float.valueOf(result[1])) );
	                  
	                   
	       case '=':  initialize(pass);
	                   i=len;  
	                  break;
	       case '.':  return "none"; 
	       
	       case '>' : try {     //i=len;   
	    	           val=pass.split("\\>");
	                  //System.out.println(val[1]);
	                  //System.out.println(pass+":"+data.get(val[1]));
	                	   print(val); }
	                       catch(java.lang.ArrayIndexOutOfBoundsException in) { System.out.println("Expected expression:\n");
	                        return "none";}
	                           break;
	                             
	    default : System.out.println("Error");
	                 
	       }
	        }
	         } 
	     
	    	// print(pass); 
	    	 } }
	  catch(java.lang.StringIndexOutOfBoundsException p) { System.out.println("Syntax error : \n");}

	  //System.out.println("Command not found\n");
     return pass; 
}




private static void looping(String[] loop2) {
	// TODO Auto-generated method stub
	int total =0,t2=0;
	//System.out.print(loop2[0]+"\t"+loop2[1]+"\t"+loop2[2].length()+"\n");
	for(int l=0;l<loop2[2].length();l++)
	{   t2+=l;
		if(Character.isDigit(loop2[2].charAt(l))) {
		total+=l;	
		}
	}
	 if(loop2[0].equals("LOOP")) {
		  if(loop[2].length()==0 ) {System.out.println("System.out.println(\"Syntax Error: Expected 'LOOP:_operation_:_int_ '\n");}
		  else if(total==t2){ int times = Integer.valueOf(loop2[2]);
		 for(int y=0;y<times;y++) 
		  flow(loop2[1]);}
	  }
	 else {
		 System.out.println("Syntax Error: Expected 'LOOP:_operation_:_int_ '\n");
	 }
}




private static String[] convert(String[] val1) {
	// TODO Auto-generated method stub
	boolean s,t;
	//String zero="0";
	int vsum1=0,vsum2=0;
	//String v1,v2;
	//v1=data.get(val1[0]);
	//v2=data.get(val1[1]);
	//System.out.print(val1[0]+" "+val1[1]+"\n");
	s=Character.isDigit(val1[0].charAt(0)) ;
	t=Character.isDigit(val1[1].charAt(0)) ;
	if(!s) {val1[0]=data.get(val1[0]);}
	if(!t) {val1[1]=data.get(val1[1]);}
	//System.out.print(val1[0]+" "+val1[1]+"\n");

      	if(val1[0]==null ) {	
    	                        System.out.print(" Make sure you initialize first\t\n");
	                       val1[0]="0"; }
	if(val1[1]==null) { 
	   
	  System.out.print("Make sure you initialize first\t\n");
	    val1[1]="0"; }
	//System.out.print(val1[0].length()+" "+val1 [1].length()+"\n");
	//System.out.println(val1[0]+" "+val1[1]);
	for(int i=0;i<val1[0].length();i++) {
	if(!Character.isDigit(val1[0].charAt(i)) && !(val1[0].charAt(i)=='.')) {
		System.out.print("Adding String or char to number !!!!\n");
		for(int j=0;j<val1[0].length();j++)
		{ vsum1+=(int)val1[0].charAt(i);}
		val1[0]=Integer.toString(vsum1);
		break;
		}  
	}
	for(int i=0;i<val1[1].length();i++) {
		if(!Character.isDigit(val1[0].charAt(i)) && !(val1[0].charAt(i)=='.')) {
			System.out.print(" Performing operation on  String or char !!!!\n");
			for(int j=0;j<val1[1].length();j++)
			{ vsum2+=(int)val1[1].charAt(i);}
			val1[1]=Integer.toString(vsum2);
			break;
			}  
		}

	return val1;
}



private static void print(String[] val) {
	  //System.out.println("In print\n");
	index= search(val[1],Names);
	//System.out.println(val[1]+"\n");
	   if(index==-1 && data.get(val[1])==null) 
	   {System.out.println("Variable not initialized\n"); 
	   }
	   else if(index==-1) 
	   {System.out.println(val[1]+":"+data.get(val[1]));
		   //System.out.println("Stack not  INITIALIZED !!\n"); 
		 }
     else if(data.get(val[1])==null) 
     {stack[index].print(); }
	else {System.out.println("Error : "+val[1]+"  may be ambigious\n");}
	
	  
	
	
}
private static void initialize(String pass) {
	//System.out.println("In initialize\n");
	// TODO Auto-generated method stub
	 String[] d;
	   //int s=0;
	      //float data[]= new float[500];
	      String str;
	  boolean f = false;
	  boolean t= false;
    //int l=p.length();return result; return result; 
	     d=pass.split("\\=");
	    // System.out.println(d[0]+"\t"+d[1]+"\n");
	      str=flow(d[1]);
	      if(!(str.equals(d[1]))) {  data.put(d[0], str);}
	      else
	          {  int l1=d[0].length();int l2 = d[1].length();
	               for(int j=0;j<l1;j++){
	                   f = Character.isDigit(d[0].charAt(j));
	                   }
	      for(int k=0;k<l2;k++) {t=Character.isDigit(d[1].charAt(k));}
	     if(f) {
	    	 System.out.println("Variable name should not starts with number\n");}
	     else if(t){  
	       data.put(d[0],d[1]);
	       
	        //System.out.println("initializing done.....\n"+data.get(d[0]));
	       //System.out.println(data[s-97]);
	     }
	     else { 
	 
	    	 data.put(d[0],d[1]);
	    	 // System.out.println("initializing done.....\n");
     //System.out.println(string[s-97]);}
}}
	  

}
static void stack(String val,int l)
{   
int j=l+1;
    
while(!(val.charAt(j)=='|')){ j++;}
String Sname=val.substring(l+1,j);
//System.out.println(j+"\t"+l+"\t"+Sname+"\n");
f=0;
index=search(Sname,Names);

if(f==1){  
	System.out.println("Stack already initialized\n");
	}

   else 
   { Names[++count]=Sname; 
   stack[count] = new MyDynamicStack(3,Sname);
   //System.out.println("Initilization done\t"+Names[count]+"\n");
   }
    
    
     
}

static int search(String nme,String name[])
{    //System.out.println(count);
 if(count>0) {for(int i=1;i<=count;i++){  
	             //System.out.println(name[i]+""+nme+"\n");
	             if(name[i].equals(nme)) 
	               {f=1;  return i;}
           }}
 
        return -1;
  
 
}

static void stack_op(String val1,char sym,int j)
{  String value = val1.substring(j+1);
//System.out.println(value+"\t"+val1.substring(0,j-1)+"\n");
 index=search(val1.substring(0,j-1),Names);
  if(index>0){ 
  
        switch(sym)
        {
          case'>':   if(value.isEmpty()) {System.out.println("No value given to push :"); return ;}
                      int data = Integer.valueOf(value);
                     //System.out.println(data);
                     stack[index].push(data);
                     break;
        
          
         case '-':   try { 
        	 
				 if(val1.charAt(j-1)=='<')  {stack[index].pop();}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                     break;
        
          default : System.out.println("Error in syntax\n");
         
        
        
        }  
        }
  else {System.out.println("Error : unknown variable \n");}

 }
   
}
