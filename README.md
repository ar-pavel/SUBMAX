# SUBMAX
IPV4 Subnet-Calculator RESTfull API
*version 1.1*

`Live: [http://submaxvlsm.herokuapp.com](http://submaxvlsm.herokuapp.com) `

VLSM or Variable Length Subnet Masking is a process of allocating subnet masks where the length is not restricted by IP classes. It allows subdividing a subnet for
more optimal usage and less IP wastage. ASAS This app helps user calculate optimal subnet allocation. The process of using it as follows:
 1. Enter the Network ID your ISP has provided you in (a.b.c.d/mask) format, which is known as CIDR format.
 2. Enter the Host Group information (Name and Size) .
  For example:
  1. Home Office (10 devices)
  2. Kitchen (4 devices)
  3. Basement (8 devices)
3. Click Calculate Subnect Allocation button to get the allocation result in terms of {network ID, gateway address, broadcast address} for every
group.

##### updates of 1.1
  1. GNS3 Topology integration implemented.
   Now you can:
    1. Upload gns3 project file(s) and the host groups from there will be calculated automatically for you.
   2. The host groups will be identified by their interface with router in this format Name1_port_Name1_port . For example: Router1_0_Switch2_1
   3. You can upload multiple gns3 files, and alloc
