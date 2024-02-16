#include<iostream>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;

char Map[13][7];
int Visit[13][7];

int Explosion = 0;				// 현재 회차 폭발의 수
int Total_Explosion = 0;		// 총 연쇄반응 수


int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
vector<pair<int, int>> Vector;


void Input() {
	for (int i = 1; i <= 12; i++) {
		for (int j = 1; j <= 6; j++) {
			cin >> Map[i][j];
		}
	}
}

void Dfs(int x, int y) {

	char ch = Map[x][y]; // ch 에 색상 정보를 저장

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 1 || ny < 1 || nx > 12 || ny > 6) continue;		//범위 초과
		if (Visit[nx][ny] == 1 || Map[nx][ny] == '.') continue;		//방문 기록 & 빈공간
		if (Map[nx][ny] != Map[x][y]) continue;						//같은 색상이 아닌 경우

		Visit[nx][ny] = 1;				//방문 체크
		Vector.push_back({ nx, ny });	//좌표 정보 삽입
		Dfs(nx, ny);					//Recursion
	}

}


void gravity(int x, int y) {

	//바로 아래 좌표
	int nx = x + 1;
	int ny = y;

	if (nx > 12) return;				//범위 초과
	if (Map[nx][ny] != '.') return;		//끝까지 닿음

	char temp = Map[x][y];
	Map[x][y] = Map[nx][ny];
	Map[nx][ny] = temp;					//아래 값과 위치를 바꿈
	gravity(nx, ny);					//값은 그대로, 좌표만 다르게 재귀 투입
}


void Drop() {

	for (int i = 12; i >= 1; i--) {
		for (int j = 6; j >= 1; j--) {
			//맨 아래 오른쪽부터 탐색
			if (Map[i][j] == '.') continue;
			gravity(i, j);
			// 색상좌표 투입
		}
	}

}





int main() {
	Input();

	while (true) {

		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 6; j++) {
				if (Map[i][j] == '.' || Visit[i][j] == 1) continue;
				Visit[i][j] = 1;
				Vector.push_back({ i, j });
				Dfs(i, j);	// Vector 에 같은 색상 필드의 넓이 정보가 저장된 상태


				if (Vector.size() >= 4) {
					Explosion++; //폭발 추가
					for (int i = 0; i < Vector.size(); i++) {
						int px = Vector[i].first;
						int py = Vector[i].second;
						Map[px][py] = '.';
					} // 빈칸으로 만들기
				}

				Vector.clear();
				memset(Visit, 0, sizeof(Visit));
				//초기화 작업
			}
		}


		if (Explosion == 0) break;
		else {
			Total_Explosion++;
			Explosion = 0;
			Drop();
			continue;
		}

	}

	cout << Total_Explosion << '\n';

}