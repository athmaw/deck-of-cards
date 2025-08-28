#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX 10

typedef struct{
	int elem[MAX];
	int count;
} List;

List L;

List initList(List L);
List insertPos(List L, int data, int pos);
List deletePos(List L, int pos);
//int locate(int L, int data);
List insertSorted(List L, int data);
void display(List L);

int main() {
    List L = initList(L);

	L.elem[0] = 1;
    L.elem[1] = 3;
    L.elem[2] = 2;
    L.elem[3] = 5;
    L.count = 4;
	printf("ORIGINAL ELEMENTS = ");
    display(L);
    
    L = insertPos(L, 4, 2);
    printf("AFTER INSERTING POSITION = ");
	display(L);
    
    L = deletePos(L, 4);
    printf("AFTER DELETING = ");
	display(L);
    
//    int Ndx = locate(L, 4);
//    
//    if(Ndx != - 1) {
//    	printf("Value found at index %d\n", Ndx);
//	} else{
//		printf("Value not found\n");
//	}
    
    L = insertSorted(L, 6);
    printf("AFTER SORTED INSERT = ");
	display(L);
    
    return 0;
}

List initList(List L) {
	L.count = 0;
	
	return L;
}

List insertPos(List L, int data, int pos) {
    int i;

	if(pos <= L.count && L.count < MAX) {
        for(i = L.count; i > pos; i--) {
            L.elem[i] = L.elem[i - 1];
        }
        L.elem[pos] = data;
        L.count++;
    }

    return L;
}

List deletePos(List L, int pos) {
	int i;
	
	if(pos < L.count) {
		for(i = pos; i < L.count - 1; i++) {
			L.elem[i] = L.elem[i + 1];
		}
		L.count--;
	}
	
	return L;
}

//int locate(List L, int data) {
//	int i;
//	
//	for(i = 0; i < L.count; i++) {
//		if(L.elem[i] == data) {
//			return i;
//		}
//	}
//	
//	return -1;
//}

List insertSorted(List L, int data) {
	int i;
	
	if(L.count == MAX) {
		printf("List is FULL.\n");
		
		return L;
	}
	
	i = L.count - 1;
	
	while(i >= 0 && L.elem[i] > data) {
		L.elem[i + 1] = L.elem[i];
		i--;
	}
	
	L.elem[i + 1] = data;
	L.count++;
	
	return L;
}

void display(List L) {
	int i;
	
    for(i = 0; i < L.count; i++) {
        printf("%d ", L.elem[i]);
    }
    printf("\n");
}