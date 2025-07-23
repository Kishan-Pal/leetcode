class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 1000000;
        int[][] graph = new int[n + 1][n + 1];

        // Inicializar matriz de adyacencia con infinito
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        // Construir grafo
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph[u][v] = w;
        }

        // Dijkstra
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // Inicializar distancias
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        dist[k] = 0;

        for (int i = 1; i <= n; i++) {
            int u = -1;
            int min = INF;
            // Encontrar el nodo no visitado con menor distancia
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            if (u == -1) break; // Todos los nodos restantes son inaccesibles
            visited[u] = true;

            // Actualizar distancias a vecinos de u
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Obtener la distancia máxima
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;
            if (dist[i] > maxTime) maxTime = dist[i];
        }

        return maxTime;
    }
}