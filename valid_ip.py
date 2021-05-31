class Solution:
    def validIPAddress(self, IP: str) -> str:
        
        if '.' in IP:
            ip_list = IP.split('.')
        else:
            ip_list = IP.split(':')
            
        if len(ip_list)==4:
            
            max = 0
            
            for x in ip_list:
                
                if len(x) > 1 and x[0] == '0':
                
                    return 'Neither'
                
                try:
                    if int(x) >=0 and int(x) <=255:
                        max += 1
                    else:
                        return 'Neither'
                        
                except Exception as e:
                    return 'Neither'
                    
            
            if max==4:
                return 'IPv4'
        
        elif len(ip_list)==8:
            
            max = 0
            
            for x in ip_list:
                
                if len(x)>=1 and len(x)<=4:
                    
                    try:
                        i = int(x, 16)
                        max += 1
                    except Exception as e:
                        return 'Neither'
                else:
                    return 'Neither'
            
            if max==8:
                return 'IPv6'
        else:
            return 'Neither'
                
                
        